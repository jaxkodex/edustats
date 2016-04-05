package pe.org.edustats.service.converter;

import org.springframework.stereotype.Component;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.model.PeriodoAcademico;

public class PeriodoAcademicoBeanToModelConverter extends AbstractDataConverter<PeriodoAcademicoBean, PeriodoAcademico> {

  @Override
  public PeriodoAcademico convert(PeriodoAcademicoBean periodoAcademicoBean) {
    if (periodoAcademicoBean == null) {
      return null;
    }
    PeriodoAcademico periodoAcademico = new PeriodoAcademico();
    
    periodoAcademico.setCoPeriodoAcademico(periodoAcademicoBean.getCoPeriodoAcademico());
    periodoAcademico.setFeFin(periodoAcademicoBean.getFeFin());
    periodoAcademico.setFeInicio(periodoAcademicoBean.getFeInicio());
    periodoAcademico.setIdPeriodoAcademico(periodoAcademicoBean.getIdPeriodoAcademico());
    
    return periodoAcademico;
  }

}
