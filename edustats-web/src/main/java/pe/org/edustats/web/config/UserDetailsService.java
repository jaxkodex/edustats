package pe.org.edustats.web.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.edustats.data.bean.OpcionBean;
import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.data.model.Opcion;
import pe.org.edustats.data.model.Rol;
import pe.org.edustats.data.model.Usuario;
import pe.org.edustats.data.repository.UsuarioRepository;
import pe.org.edustats.service.converter.OpcionModelToBeanConverter;

@Service
public class UserDetailsService
    implements org.springframework.security.core.userdetails.UserDetailsService {
  private static final Logger LOGGER = LogManager.getLogger(UserDetailsService.class);
//  @Autowired
//  private UsuarioService usuarioService;
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    UsuarioBean usuario = usuarioService.cargarUsuarioPorNoCuenta(username);
    List<Usuario> usuarios = usuarioRepository.findByNoCuenta(username);
    if (usuarios.isEmpty()) {
      throw new UsernameNotFoundException("Usuario no encontrado :(");
    }
    OpcionModelToBeanConverter opcionConverter = new OpcionModelToBeanConverter();
    Usuario usuario = usuarios.get(0);
    
    LOGGER.trace("Buscando usuario");
    
    List<GrantedAuthority> authorities = new ArrayList<>();
    Map<Integer, OpcionBean> opcionMap = new HashMap<>();
    for (Rol rol : usuario.getRoles()) {
      for (Opcion opcion : rol.getOpciones()) {
        
        if (opcionMap.get(opcion.getIdOpcion()) == null) {
          opcionMap.put(opcion.getIdOpcion(), opcionConverter.convert(opcion));
          GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.format("ROLE_%s", opcion.getCoOpcion()));
          authorities.add(grantedAuthority);
          LOGGER.trace(String.format("Dando permiso: %s", opcion.getCoOpcion()));
        }
      }
    }

    UserDetails details = new User(username, usuario.getCoContrasenia(), authorities);
    return details;
  }
}
