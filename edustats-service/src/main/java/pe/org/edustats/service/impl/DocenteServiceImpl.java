package pe.org.edustats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.org.edustats.data.bean.CargoBean;
import pe.org.edustats.data.bean.PersonaBean;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.data.model.Cargo;
import pe.org.edustats.data.model.Persona;
import pe.org.edustats.data.model.Trabajador;
import pe.org.edustats.data.repository.PersonaRepository;
import pe.org.edustats.data.repository.TrabajadorRepository;
import pe.org.edustats.service.DocenteService;
import pe.org.edustats.service.converter.PersonaBeanToModelConverter;
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
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public TrabajadorBean create(TrabajadorBean trabajadorBean) throws DataValidationException {
        PersonaBean personaBean = trabajadorBean.getPersona();
        DataValidator<PersonaBean> personaBeanDataValidator;
        personaBeanDataValidator = new DataValidator<>(new PersonaBeanValidator(), messageSource);
        personaBeanDataValidator.validate(personaBean);

        PersonaBeanToModelConverter pToModelConverter = new PersonaBeanToModelConverter();

        List<Persona> personas = personaRepository.findByNuDocumentoAndTipoDocumentoIdTipoDocumento(personaBean.getNuDocumento(), personaBean.getTipoDocumento().getIdTipoDocumento());

        Persona persona;
        if (!personas.isEmpty()) {
            persona = personas.get(0);
            persona.setApPersona(personaBean.getApPersona());
            persona.setAmPersona(personaBean.getAmPersona());
            persona.setNoPersona(personaBean.getNoPersona());
            persona.setFeNacimiento(personaBean.getFeNacimiento());
        } else {
            persona = pToModelConverter.convert(trabajadorBean.getPersona());
        }
        persona = personaRepository.save(persona);

        Trabajador trabajador = new Trabajador();
        trabajador.setPersona(persona);
        trabajador.setCargo(new Cargo());
        trabajador.getCargo().setCoCargo(CargoEnum.DOCENTE.getCoCargo());

        trabajador = trabajadorRepository.save(trabajador);

        return new TrabajadorModelToBeanConverter().convert(trabajador);
    }

    @Override
    public TrabajadorBean update(TrabajadorBean trabajadorBean) throws DataValidationException {
        PersonaBean personaBean = trabajadorBean.getPersona();
        DataValidator<PersonaBean> personaBeanDataValidator;
        personaBeanDataValidator = new DataValidator<>(new PersonaBeanValidator(), messageSource);
        personaBeanDataValidator.validate(personaBean);


        List<Persona> personas = personaRepository.findByNuDocumentoAndTipoDocumentoIdTipoDocumento(personaBean.getNuDocumento(), personaBean.getTipoDocumento().getIdTipoDocumento());

        PersonaBeanToModelConverter pToModelConverter = new PersonaBeanToModelConverter();
        Persona persona;
        if (!personas.isEmpty()) {
            persona = personas.get(0);
            persona.setApPersona(personaBean.getApPersona());
            persona.setAmPersona(personaBean.getAmPersona());
            persona.setNoPersona(personaBean.getNoPersona());
            persona.setFeNacimiento(personaBean.getFeNacimiento());
        } else {
            persona = pToModelConverter.convert(trabajadorBean.getPersona());
        }
        persona = personaRepository.save(persona);

        List<Trabajador> trabajadores = trabajadorRepository.findByPersonaIdPersonaAndCargoCoCargo(persona.getIdPersona(), CargoEnum.DOCENTE.getCoCargo());
        Trabajador trabajador = trabajadores.get(0);
        trabajador.setPersona(persona);
        trabajador.setCargo(new Cargo());
        trabajador.getCargo().setCoCargo(CargoEnum.DOCENTE.getCoCargo());

        trabajador = trabajadorRepository.save(trabajador);

        return new TrabajadorModelToBeanConverter().convert(trabajador);
    }

    @Override
    public List<TrabajadorBean> consultaPorNuDocumento(String nuDocumento, String idTipoDocumento) {
        List<Trabajador> trabajadores = trabajadorRepository.findByPersonaNuDocumentoAndPersonaTipoDocumentoIdTipoDocumentoAndCargoCoCargo(nuDocumento, idTipoDocumento, CargoEnum.DOCENTE.getCoCargo());
        return new TrabajadorModelToBeanConverter().convertList(trabajadores);
    }
}
