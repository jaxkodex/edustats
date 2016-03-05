package pe.org.edustats.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.org.edustats.data.bean.InstitucionEducativaBean;

public class InstitucionEducativaBeanValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return InstitucionEducativaBean.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "noInstitucionEducativa", "campo.requerido", new String[] {"nombre"});
  }

}
