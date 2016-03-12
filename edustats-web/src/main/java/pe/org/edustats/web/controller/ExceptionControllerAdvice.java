package pe.org.edustats.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pe.org.edustats.service.exception.DataValidationException;

@ControllerAdvice(basePackages = {"pe.org.edustats.web.controller.api"})
public class ExceptionControllerAdvice {

  @ExceptionHandler({DataValidationException.class})
  @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public Map<String, Object> onDataValidationException (DataValidationException dataValidationErrorException) {
      Map<String, Object> response = new HashMap<>();
      response.put("errors", dataValidationErrorException.getErrors());
      return response;
  }
  
  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(code=HttpStatus.FORBIDDEN)
  @ResponseBody
  public Map<String, Object> exception(AccessDeniedException e) {
    Map<String, Object> response = new HashMap<>();
    response.put("status", "Permiso denegado");
    return response;
  }
}
