package pe.org.edustats.service.converter;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.OpcionBean;
import pe.org.edustats.data.bean.RolBean;
import pe.org.edustats.data.model.Opcion;
import pe.org.edustats.data.model.Rol;

public class RolModelToBeanConverter extends AbstractDataConverter<Rol, RolBean> {
  private static final Logger LOGGER = LogManager.getLogger(RolModelToBeanConverter.class);

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
      LOGGER.trace("Opcion: "+opcion.getDeOpcion());
      OpcionBean opcionBean = opcionConverter.convert(opcion);
      if (opcion.getOpcionPadre() != null) {
        opcionBean.setOpcionPadre(opcionConverter.convert(opcion.getOpcionPadre()));
      }
      rolBean.getOpciones().add(opcionBean);
    }
    
    return rolBean;
  }

}
