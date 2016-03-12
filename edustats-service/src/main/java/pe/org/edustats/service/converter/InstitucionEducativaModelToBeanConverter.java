package pe.org.edustats.service.converter;

import org.springframework.stereotype.Component;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.model.InstitucionEducativa;

@Component
public class InstitucionEducativaModelToBeanConverter extends AbstractDataConverter<InstitucionEducativa, InstitucionEducativaBean> {

  @Override
  public InstitucionEducativaBean convert(InstitucionEducativa institucionEducativa) {
    if (institucionEducativa == null) {
      return null;
    }
    
    InstitucionEducativaBean ie = new InstitucionEducativaBean();
    ie.setIdIntitucionEducativa(institucionEducativa.getIdInstitucionEducativa());
    ie.setNoInstitucionEducativa(institucionEducativa.getNoInstitucionEducativa());
    ie.setNuInstitucionEducativa(institucionEducativa.getNuInstitucionEducativa());
    
    return ie;
  }

}
