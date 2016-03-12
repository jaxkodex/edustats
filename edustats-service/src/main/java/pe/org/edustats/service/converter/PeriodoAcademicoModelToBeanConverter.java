package pe.org.edustats.service.converter;

import org.springframework.stereotype.Component;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.model.PeriodoAcademico;

public class PeriodoAcademicoModelToBeanConverter extends AbstractDataConverter<PeriodoAcademico, PeriodoAcademicoBean> {

  @Override
  public PeriodoAcademicoBean convert(PeriodoAcademico periodoAcademico) {
    if (periodoAcademico == null) {
      return null;
    }
    PeriodoAcademicoBean periodoAcademicoBean = new PeriodoAcademicoBean();
    
    periodoAcademicoBean.setCoPeriodoAcademico(periodoAcademico.getCoPeriodoAcademico());
    periodoAcademicoBean.setFeFin(periodoAcademico.getFeFin());
    periodoAcademicoBean.setFeInicio(periodoAcademico.getFeInicio());
    periodoAcademicoBean.setIdPeriodoAcademico(periodoAcademico.getIdPeriodoAcademico());
    
    return periodoAcademicoBean;
  }

}
