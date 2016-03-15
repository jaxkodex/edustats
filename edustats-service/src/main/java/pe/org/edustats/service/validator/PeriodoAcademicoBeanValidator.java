package pe.org.edustats.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.org.edustats.data.bean.PeriodoAcademicoBean;

public class PeriodoAcademicoBeanValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return PeriodoAcademicoBean.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "coPeriodoAcademico", "campo.requerido", new Object[] {"código"});
    ValidationUtils.rejectIfEmpty(errors, "feInicio", "campo.requerido", new Object[] {"fecha de inicio"});
    ValidationUtils.rejectIfEmpty(errors, "institucionEducativa", "campo.requerido", new Object[] {"institucion educativa"});
  }

}
