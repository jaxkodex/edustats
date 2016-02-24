package pe.org.edustats.service.converter;

import java.util.ArrayList;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.OpcionBean;
import pe.org.edustats.data.bean.RolBean;
import pe.org.edustats.data.model.Opcion;
import pe.org.edustats.data.model.Rol;

public class RolModelToBeanConverter extends AbstractDataConverter<Rol, RolBean> {

  @Override
  public RolBean convert(Rol rol) {
    if (rol == null) {
      return null;
    }
    OpcionModelToBeanConverter opcionConverter = new OpcionModelToBeanConverter();
    
    RolBean rolBean = new RolBean();
    rolBean.setIdRol(rol.getIdRol());
    rolBean.setNoRol(rol.getNoRol());
    rolBean.setOpciones(new ArrayList<OpcionBean>());
    
    for (Opcion opcion : rol.getOpciones()) {
      OpcionBean opcionBean = opcionConverter.convert(opcion);
      if (opcion.getOpcionPadre() != null) {
        opcionBean.setOpcionPadre(opcionConverter.convert(opcion));
      }
      rolBean.getOpciones().add(opcionBean);
    }
    
    return rolBean;
  }

}
