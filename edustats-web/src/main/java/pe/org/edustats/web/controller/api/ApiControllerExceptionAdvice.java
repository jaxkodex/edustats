package pe.org.edustats.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.service.util.MessageResolver;
import pe.org.edustats.service.util.ServiceConstants;

/**
 * This class will hold all common exceptions with predicatable responses for the api
 * @author Jorge
 *
 */
@ControllerAdvice(basePackages = {"pe.org.edustats.web.controller.api"})
public class ApiControllerExceptionAdvice {
  @Autowired
  private MessageResolver messageResolver;

  /**
   * This exception will respond with http code 422
   * since there was a problem with the data validation
   * in the service layer
   * @param dataValidationErrorException thrown when a validation failed
   * @return map containing the validation errors
   */
  @ExceptionHandler({DataValidationException.class})
  @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public Map<String, Object> onDataValidationException (DataValidationException dataValidationErrorException) {
      Map<String, Object> response = new HashMap<>();
      response.put("errors", dataValidationErrorException.getErrors());
      return response;
  }
  
  /**
   * Default handler access denied exception
   * @param e exception
   * @return a map with default validation
   */
  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(code=HttpStatus.FORBIDDEN)
  @ResponseBody
  public Map<String, Object> exception(AccessDeniedException e) {
    Map<String, Object> response = new HashMap<>();
    response.put("status", messageResolver.getMessage(ServiceConstants.MC_ACCESS_DENIED));
    return response;
  }
}
