package pe.org.edustats.service;

import java.util.Date;
import java.util.List;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

public interface PeriodoAcademicoService {

  public List<PeriodoAcademicoBean> consultaPorInstitucionEducativa(Integer idInstitucionEducativa);
  
  public PeriodoAcademicoBean consultaPorId(Integer idPeriodoAcademico);
  
  public PeriodoAcademicoBean aperturarPeriodoAcademico (String coPeriodoAcademico, Date feInicio, InstitucionEducativaBean institucionEducativaBean) throws ApplicationException, DataValidationException;
  
  /**
   * Verifica si existe periodo academico aperturado para la institucion educativa
   * 
   * @param idInstitucionEducativa a consultar
   * @return true si existen periodos aperturados, false en caso contrario
   */
  public boolean hayPeriodoAcademicoAperturado (Integer idInstitucionEducativa);

}
