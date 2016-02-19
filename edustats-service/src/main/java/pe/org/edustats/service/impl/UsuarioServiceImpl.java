package pe.org.edustats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.edustats.data.model.Usuario;
import pe.org.edustats.data.repository.UsuarioRepository;
import pe.org.edustats.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public Usuario cargarUsuarioPorNoCuenta(String noCuenta) {
    List<Usuario> usuarios = usuarioRepository.findByNoCuenta(noCuenta);
    return null;
  }

}
