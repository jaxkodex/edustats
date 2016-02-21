package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.data.model.Usuario;

/**
 * Convierte un modelo de base de datos en bean para poder serializarlo
 * @author Jorge
 *
 */
public class UsuarioModelToBeanConverter extends AbstractDataConverter<Usuario, UsuarioBean> {

  @Override
  public UsuarioBean convert(Usuario usuario) {
    if (usuario == null) {
      return null;
    }
    PersonaModelToBeanConverter personaConverter = new PersonaModelToBeanConverter();
    RolModelToBeanConverter rolConverter = new RolModelToBeanConverter();
    
    UsuarioBean usuarioBean = new UsuarioBean();
    usuarioBean.setIdUsuario(usuario.getIdUsuario());
    usuarioBean.setNoCuenta(usuario.getNoCuenta());
    usuarioBean.setPersona(personaConverter.convert(usuario.getPersona()));
    usuarioBean.setRoles(rolConverter.convertList(usuario.getRoles()));
    
    return usuarioBean;
  }

}
