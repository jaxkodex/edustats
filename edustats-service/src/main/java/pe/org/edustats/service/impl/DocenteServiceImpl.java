package pe.org.edustats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.org.edustats.data.bean.CargoBean;
import pe.org.edustats.data.bean.PersonaBean;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.data.model.Trabajador;
import pe.org.edustats.data.repository.TrabajadorRepository;
import pe.org.edustats.service.DocenteService;
import pe.org.edustats.service.converter.TrabajadorBeanToModelConverter;
import pe.org.edustats.service.converter.TrabajadorModelToBeanConverter;
import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.service.util.DataValidator;
import pe.org.edustats.service.util.ServiceConstants;
import pe.org.edustats.service.util.enums.CargoEnum;
import pe.org.edustats.service.validator.PersonaBeanValidator;

/**
 * Created by Jorge on 05/04/2016.
 */
@Service
public class DocenteServiceImpl implements DocenteService {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public TrabajadorBean create(TrabajadorBean trabajadorBean) throws DataValidationException {
        DataValidator<PersonaBean> personaBeanDataValidator;
        personaBeanDataValidator = new DataValidator<>(new PersonaBeanValidator(), messageSource);
        personaBeanDataValidator.validate(trabajadorBean.getPersona());

        trabajadorBean.setCargo(new CargoBean());
        trabajadorBean.getCargo().setCoCargo(CargoEnum.DOCENTE.getCoCargo());
        TrabajadorBeanToModelConverter tToModelConverter = new TrabajadorBeanToModelConverter();
        Trabajador trabajador = tToModelConverter.convert(trabajadorBean);
        trabajador.setIdTrabajador(null);

        trabajador = trabajadorRepository.save(trabajador);

        return new TrabajadorModelToBeanConverter().convert(trabajador);
    }

    @Override
    public TrabajadorBean update(TrabajadorBean trabajadorBean) throws DataValidationException {
        DataValidator<PersonaBean> personaBeanDataValidator;
        personaBeanDataValidator = new DataValidator<>(new PersonaBeanValidator(), messageSource);
        personaBeanDataValidator.validate(trabajadorBean.getPersona());

        trabajadorBean.setCargo(new CargoBean());
        trabajadorBean.getCargo().setCoCargo(CargoEnum.DOCENTE.getCoCargo());

        TrabajadorBeanToModelConverter tToModelConverter = new TrabajadorBeanToModelConverter();
        Trabajador trabajador = tToModelConverter.convert(trabajadorBean);

        trabajador = trabajadorRepository.save(trabajador);

        return new TrabajadorModelToBeanConverter().convert(trabajador);
    }

    @Override
    public List<TrabajadorBean> consultaPorNuDocumento(String nuDocumento) {
        List<Trabajador> trabajadores = trabajadorRepository.findByPersonaNuDocumentoAndCargoCoCargo(nuDocumento, CargoEnum.DOCENTE.getCoCargo());
        return new TrabajadorModelToBeanConverter().convertList(trabajadores);
    }
}
