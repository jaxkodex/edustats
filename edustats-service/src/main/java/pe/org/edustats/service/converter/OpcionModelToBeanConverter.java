package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.OpcionBean;
import pe.org.edustats.data.model.Opcion;

public class OpcionModelToBeanConverter extends AbstractDataConverter<Opcion, OpcionBean> {

  @Override
  public OpcionBean convert(Opcion opcion) {
    if (opcion == null) {
      return null;
    }
    
    OpcionBean opcionBean = new OpcionBean();
    opcionBean.setIdOpcion(opcion.getIdOpcion());
    opcionBean.setDeOpcion(opcion.getDeOpcion());
    opcionBean.setCoOpcion(opcion.getCoOpcion());
    opcionBean.setDeRuta(opcion.getDeRuta());
    
    return opcionBean;
  }

}
