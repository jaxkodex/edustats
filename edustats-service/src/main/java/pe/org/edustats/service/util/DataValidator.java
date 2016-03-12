package pe.org.edustats.service.util;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

import pe.org.edustats.service.exception.DataValidationException;

public class DataValidator<T> {
  private Validator validator;
  private MessageSource messageSource;
  
  public DataValidator (Validator validator, MessageSource messageSource) {
    this.validator = validator;
    this.messageSource = messageSource;
  }
  
  public void validate (T target) throws DataValidationException {
    DataBinder binder = new DataBinder(target);
    binder.setValidator(validator);
    binder.validate();
    BindingResult result = binder.getBindingResult();
    if (result.hasErrors()) {
      throw new DataValidationException(result, messageSource);
    }
  }
}
