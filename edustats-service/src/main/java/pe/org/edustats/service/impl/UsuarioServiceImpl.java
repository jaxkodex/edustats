package pe.org.edustats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.data.model.Usuario;
import pe.org.edustats.data.repository.UsuarioRepository;
import pe.org.edustats.service.UsuarioService;
import pe.org.edustats.service.converter.UsuarioModelToBeanConverter;

@Service
public class UsuarioServiceImpl implements UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  @Transactional
  public UsuarioBean cargarUsuarioPorNoCuenta(String noCuenta) {
    List<Usuario> usuarios = usuarioRepository.findByNoCuenta(noCuenta);
    UsuarioBean usuarioBean = null;
    if (!usuarios.isEmpty()) {
      Usuario usuario = usuarios.get(0);
      UsuarioModelToBeanConverter converter = new UsuarioModelToBeanConverter();
      usuarioBean = converter.convert(usuario);
    }
    return usuarioBean;
  }

}
