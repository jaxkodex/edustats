package pe.org.edustats.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.org.edustats.data.bean.PersonaBean;

/**
 * Created by Jorge on 05/04/2016.
 */
public class PersonaBeanValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PersonaBean.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "tipoDocumento", "campo.requerido", new Object[] {"Tipo de documento"});
        ValidationUtils.rejectIfEmpty(errors, "tipoDocumento.idTipoDocumento", "campo.requerido", new Object[] {"Tipo de documento"});
    }
}
