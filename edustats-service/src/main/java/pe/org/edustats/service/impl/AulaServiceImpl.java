package pe.org.edustats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.org.edustats.data.bean.AulaBean;
import pe.org.edustats.data.model.Aula;
import pe.org.edustats.data.repository.AulaRepository;
import pe.org.edustats.service.AulaService;
import pe.org.edustats.service.converter.AulaBeanToModelConverter;
import pe.org.edustats.service.converter.AulaModelToBeanConverter;
import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.service.util.DataValidator;
import pe.org.edustats.service.validator.AulaBeanValidator;

/**
 * Created by Jorge on 07/04/2016.
 */
@Service
public class AulaServiceImpl implements AulaService {
    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private MessageSource messageSource;

    @Override
    public AulaBean cargar(Integer idAula) {
        return new AulaModelToBeanConverter().convert(aulaRepository.findOne(idAula));
    }

    @Override
    public List<AulaBean> consultaPorPeriodoAcademico(Integer idPeriodoAcademico) {
        List<Aula> aulas = aulaRepository.findByPeriodoAcademicoIdPeriodoAcademico(idPeriodoAcademico);
        return new AulaModelToBeanConverter().convertList(aulas);
    }

    @Override
    public AulaBean crear(AulaBean aulaBean) throws DataValidationException {
        DataValidator<AulaBean> aulaBeanValidator = new DataValidator<>(new AulaBeanValidator(), messageSource);

        aulaBeanValidator.validate(aulaBean);

        AulaModelToBeanConverter aulaModelToBeanConverter;
        AulaBeanToModelConverter aulaBeanToModelConverter;

        aulaModelToBeanConverter = new AulaModelToBeanConverter();
        aulaBeanToModelConverter = new AulaBeanToModelConverter();

        Aula aula = aulaBeanToModelConverter.convert(aulaBean);
        aula = aulaRepository.save(aula);

        return aulaModelToBeanConverter.convert(aula);
    }
}
