package pe.org.edustats.service;

import pe.org.edustats.data.model.Usuario;

public interface UsuarioService {

  /**
   * Busca el usuario por el nombre de cuenta del usuario
   * @param noCuenta del usuario
   * @return null si no encuestra, el usuario en otro caso
   */
  public Usuario cargarUsuarioPorNoCuenta (String noCuenta);
}
