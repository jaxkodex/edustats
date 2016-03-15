package pe.org.edustats.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
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
  public List<PeriodoAcademicoBean> consultaPorInstitucionEducativa(Integer idInstitucionEducativa) {
    PeriodoAcademicoModelToBeanConverter paToBeanConverter;
    paToBeanConverter = new PeriodoAcademicoModelToBeanConverter();
    return paToBeanConverter.convertList(periodoAcademicoRepository.findByInstitucionEducativaIdInstitucionEducativa(idInstitucionEducativa));
  }

  @Override
  public PeriodoAcademicoBean consultaPorId(Integer idPeriodoAcademico) {
    PeriodoAcademicoModelToBeanConverter paToBeanConverter;
    paToBeanConverter = new PeriodoAcademicoModelToBeanConverter();
    return paToBeanConverter.convert(periodoAcademicoRepository.findOne(idPeriodoAcademico));
  }

  @Override
  public PeriodoAcademicoBean aperturarPeriodoAcademico(String coPeriodoAcademico, Date feInicio, InstitucionEducativaBean institucionEducativaBean) throws ApplicationException, DataValidationException {
    
    PeriodoAcademicoBean periodoAcademicoBean = new PeriodoAcademicoBean();
    periodoAcademicoBean.setCoPeriodoAcademico(coPeriodoAcademico);
    periodoAcademicoBean.setFeInicio(feInicio);
    periodoAcademicoBean.setInstitucionEducativa(institucionEducativaBean);
    
    DataValidator<PeriodoAcademicoBean> validator = new DataValidator<PeriodoAcademicoBean>(new PeriodoAcademicoBeanValidator(), messageSource);
    validator.validate(periodoAcademicoBean);
    
    if (hayPeriodoAcademicoAperturado(periodoAcademicoBean.getInstitucionEducativa().getIdInstitucionEducativa())) {
      String mensaje = messageResolver.getMessage(ServiceConstants.MC_EXISTE_PERIODO_ACADEMICO_APERTURADO);
      throw new ApplicationException(mensaje);
    }
    
    PeriodoAcademicoModelToBeanConverter paToBeanConverter;
    PeriodoAcademicoBeanToModelConverter paToModelConverter;
    
    paToModelConverter = new PeriodoAcademicoBeanToModelConverter();
    paToBeanConverter = new PeriodoAcademicoModelToBeanConverter();
    
    PeriodoAcademico periodoAcademico = paToModelConverter.convert(periodoAcademicoBean);
    InstitucionEducativa institucionEducativa = institucionEducativaRepository.findOne(institucionEducativaBean.getIdInstitucionEducativa());
    periodoAcademico.setInstitucionEducativa(institucionEducativa);
    
    periodoAcademico = periodoAcademicoRepository.save(periodoAcademico);
    
    return paToBeanConverter.convert(periodoAcademico);
  }

  @Override
  public boolean hayPeriodoAcademicoAperturado(Integer idInstitucionEducativa) {
    return !periodoAcademicoRepository.findByInstitucionEducativaIdInstitucionEducativaAndFeFinIsNull(idInstitucionEducativa).isEmpty();
  }

}
