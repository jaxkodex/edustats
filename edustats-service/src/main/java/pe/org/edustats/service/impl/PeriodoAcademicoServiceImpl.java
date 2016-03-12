package pe.org.edustats.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.model.InstitucionEducativa;
import pe.org.edustats.data.model.PeriodoAcademico;
import pe.org.edustats.data.repository.InstitucionEducativaRepository;
import pe.org.edustats.data.repository.PeriodoAcademicoRepository;
import pe.org.edustats.service.PeriodoAcademicoService;
import pe.org.edustats.service.converter.PeriodoAcademicoModelToBeanConverter;
import pe.org.edustats.service.converter.tomodel.PeriodoAcademicoBeanToModelConverter;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.service.util.DataValidator;
import pe.org.edustats.service.util.MessageResolver;
import pe.org.edustats.service.util.ServiceConstants;
import pe.org.edustats.service.validator.PeriodoAcademicoBeanValidator;

@Service
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
  @Autowired
  private InstitucionEducativaRepository institucionEducativaRepository;
  @Autowired
  private PeriodoAcademicoRepository periodoAcademicoRepository;
  @Autowired
  private MessageResolver messageResolver;
  @Autowired
  private MessageSource messageSource;

  @Override
  public PeriodoAcademicoBean aperturarPeriodoAcademico(String coPeriodoAcademico, Date feInicio, Integer idInstitucionEducativa) throws ApplicationException, DataValidationException {
    if (hayPeriodoAcademicoAperturado(idInstitucionEducativa)) {
      String mensaje = messageResolver.getMessage(ServiceConstants.MC_EXISTE_PERIODO_ACADEMICO_APERTURADO);
      throw new ApplicationException(mensaje);
    }
    
    PeriodoAcademicoBean periodoAcademicoBean = new PeriodoAcademicoBean();
    periodoAcademicoBean.setCoPeriodoAcademico(coPeriodoAcademico);
    periodoAcademicoBean.setFeInicio(feInicio);
    
    DataValidator<PeriodoAcademicoBean> validator = new DataValidator<PeriodoAcademicoBean>(new PeriodoAcademicoBeanValidator(), messageSource);
    validator.validate(periodoAcademicoBean);
    
    PeriodoAcademicoModelToBeanConverter paToBeanConverter;
    PeriodoAcademicoBeanToModelConverter paToModelConverter;
    
    paToModelConverter = new PeriodoAcademicoBeanToModelConverter();
    paToBeanConverter = new PeriodoAcademicoModelToBeanConverter();
    
    PeriodoAcademico periodoAcademico = paToModelConverter.convert(periodoAcademicoBean);
    InstitucionEducativa institucionEducativa = institucionEducativaRepository.findOne(idInstitucionEducativa);
    periodoAcademico.setInstitucionEducativa(institucionEducativa);
    
    periodoAcademico = periodoAcademicoRepository.save(periodoAcademico);
    
    return paToBeanConverter.convert(periodoAcademico);
  }

  @Override
  public boolean hayPeriodoAcademicoAperturado(Integer idInstitucionEducativa) {
    return !periodoAcademicoRepository.findByInstitucionEducativaIdInstitucionEducativaAndFeFinIsNull(idInstitucionEducativa).isEmpty();
  }

}
