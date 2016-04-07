package pe.org.edustats.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.org.edustats.data.bean.AulaBean;

/**
 * Created by Jorge on 07/04/2016.
 */
public class AulaBeanValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AulaBean.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "grado", "campo.requerido", new String[] {"grado"});
        ValidationUtils.rejectIfEmpty(errors, "grado.idGrado", "campo.requerido", new String[] {"grado"});

        ValidationUtils.rejectIfEmpty(errors, "seccion", "campo.requerido", new String[] {"seccion"});
        ValidationUtils.rejectIfEmpty(errors, "seccion.coSeccion", "campo.requerido", new String[] {"seccion"});
    }
}
