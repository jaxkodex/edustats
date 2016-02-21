package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.RolBean;
import pe.org.edustats.data.model.Rol;

public class RolModelToBeanConverter extends AbstractDataConverter<Rol, RolBean> {

  @Override
  public RolBean convert(Rol rol) {
    if (rol == null) {
      return null;
    }
    RolBean rolBean = new RolBean();
    rolBean.setIdRol(rol.getIdRol());
    rolBean.setNoRol(rol.getNoRol());
    return rolBean;
  }

}
