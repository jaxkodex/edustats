package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.model.InstitucionEducativa;

public class InstitucionEducativaModelToBeanConverter extends AbstractDataConverter<InstitucionEducativa, InstitucionEducativaBean> {

  @Override
  public InstitucionEducativaBean convert(InstitucionEducativa institucionEducativa) {
    if (institucionEducativa == null) {
      return null;
    }
    
    InstitucionEducativaBean ie = new InstitucionEducativaBean();
    ie.setIdIntitucionEducativa(institucionEducativa.getIdIntitucionEducativa());
    ie.setNoInstitucionEducativa(institucionEducativa.getNoInstitucionEducativa());
    ie.setNuInstitucionEducativa(institucionEducativa.getNuInstitucionEducativa());
    
    return ie;
  }

}
