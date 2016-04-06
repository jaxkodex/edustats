package pe.org.edustats.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.bean.PersonaBean;
import pe.org.edustats.data.bean.PlanillaBean;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.data.model.InstitucionEducativa;
import pe.org.edustats.data.model.PeriodoAcademico;
import pe.org.edustats.data.model.Planilla;
import pe.org.edustats.data.model.Trabajador;
import pe.org.edustats.data.repository.InstitucionEducativaRepository;
import pe.org.edustats.data.repository.PeriodoAcademicoRepository;
import pe.org.edustats.data.repository.PlanillaRepository;
import pe.org.edustats.data.repository.TrabajadorRepository;
import pe.org.edustats.service.DocenteService;
import pe.org.edustats.service.PeriodoAcademicoService;
import pe.org.edustats.service.converter.PeriodoAcademicoModelToBeanConverter;
import pe.org.edustats.service.converter.PeriodoAcademicoBeanToModelConverter;
import pe.org.edustats.service.converter.PlanillaModelToBeanConverter;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.service.util.DataValidator;
import pe.org.edustats.service.util.MessageResolver;
import pe.org.edustats.service.util.ServiceConstants;
import pe.org.edustats.service.util.enums.CargoEnum;
import pe.org.edustats.service.validator.PeriodoAcademicoBeanValidator;

@Service
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
    @Autowired
    private DocenteService docenteService;
    @Autowired
    private InstitucionEducativaRepository institucionEducativaRepository;
    @Autowired
    private PeriodoAcademicoRepository periodoAcademicoRepository;
    @Autowired
    private PlanillaRepository planillaRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;
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

        DataValidator<PeriodoAcademicoBean> validator = new DataValidator<>(new PeriodoAcademicoBeanValidator(), messageSource);
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

    @Override
    public PlanillaBean addDocenteAPlanaPeriodo(Integer idPeriodoAcademico, TrabajadorBean trabajadorBean) throws DataValidationException {
        List<Trabajador> trabajadores;
        String nuDocumento = trabajadorBean.getPersona().getNuDocumento();
        String idTipoDocumento = trabajadorBean.getPersona().getTipoDocumento().getIdTipoDocumento();
        trabajadores = trabajadorRepository.findByPersonaNuDocumentoAndPersonaTipoDocumentoIdTipoDocumentoAndCargoCoCargo(nuDocumento, idTipoDocumento, CargoEnum.DOCENTE.getCoCargo());
        if (trabajadores.isEmpty()) {
            trabajadorBean = docenteService.create(trabajadorBean);
        } else {
            trabajadorBean = docenteService.update(trabajadorBean);
        }
        Integer idTrabajador = trabajadorBean.getIdTrabajador();

        Planilla planilla = new Planilla();
        planilla.setTrabajador(new Trabajador());
        planilla.getTrabajador().setIdTrabajador(idTrabajador);
        planilla.setPeriodoAcademico(new PeriodoAcademico());
        planilla.getPeriodoAcademico().setIdPeriodoAcademico(idPeriodoAcademico);

        planilla = planillaRepository.save(planilla);

        return new PlanillaModelToBeanConverter().convert(planilla);
    }

    @Override
    @Transactional
    public List<PlanillaBean> cargarPlanilla(Integer idPeriodoAcademico) {
        List<Planilla> planilla = planillaRepository.findByIdPeriodoAcademico(idPeriodoAcademico);
        return new PlanillaModelToBeanConverter().convertList(planilla);
    }
}
