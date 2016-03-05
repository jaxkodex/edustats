package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.model.InstitucionEducativa;

public class InstitucionEducativaBeanToModelConverter extends AbstractDataConverter<InstitucionEducativaBean, InstitucionEducativa> {

  @Override
  public InstitucionEducativa convert(InstitucionEducativaBean ie) {
    if (ie == null) {
      return null;
    }
    InstitucionEducativa model = new InstitucionEducativa();
    model.setIdIntitucionEducativa(ie.getIdInstitucionEducativa());
    model.setNoInstitucionEducativa(ie.getNoInstitucionEducativa());
    model.setNuInstitucionEducativa(ie.getNuInstitucionEducativa());
    return model;
  }

}
