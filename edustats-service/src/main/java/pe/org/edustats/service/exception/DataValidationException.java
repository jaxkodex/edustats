package pe.org.edustats.service.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class DataValidationException extends Exception {
  private static final long serialVersionUID = 1L;

  private static final String ATTRIBUTE_CODE = "attribute";
  private static final String ERROR_CODE = "error";

  private BindingResult bindingResult;
  private MessageSource messageSource;

  public DataValidationException(BindingResult bindingResult, MessageSource messageSource) {
    super("Error de validación");
    this.bindingResult = bindingResult;
    this.messageSource = messageSource;
  }

  public List<Map<String, String>> getErrors() {
    List<Map<String, String>> errors = new ArrayList<>();

    for (Object object : bindingResult.getAllErrors()) {
      if (object instanceof FieldError) {
        Map<String, String> errorDetail = new HashMap<>();
        FieldError fieldError = (FieldError) object;
        String field = fieldError.getField();
        String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
        errorDetail.put(ATTRIBUTE_CODE, field);
        errorDetail.put(ERROR_CODE, message);

        errors.add(errorDetail);
      }
    }

    return errors;
  }
}
