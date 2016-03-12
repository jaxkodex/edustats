package pe.org.edustats.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.service.PeriodoAcademicoService;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

@RestController
public class PeriodoAcademicoApiController {
  @Autowired
  private PeriodoAcademicoService periodoAcademicoService;

  @RequestMapping(value = "/api/periodoAcademico", method = RequestMethod.POST)
  public ResponseEntity<PeriodoAcademicoBean> aperturarPeriodoAcademico(@RequestBody PeriodoAcademicoBean periodoAcademicoBean) throws ApplicationException, DataValidationException {
    periodoAcademicoBean = periodoAcademicoService.aperturarPeriodoAcademico(periodoAcademicoBean.getCoPeriodoAcademico(),
        periodoAcademicoBean.getFeInicio(),
        periodoAcademicoBean.getInstitucionEducativaBean().getIdInstitucionEducativa());
    return new ResponseEntity<PeriodoAcademicoBean>(periodoAcademicoBean, HttpStatus.CREATED);
  }
  
  @ExceptionHandler({DataValidationException.class})
  @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
  public Map<String, Object> onDataValidationException (DataValidationException dataValidationErrorException) {
      Map<String, Object> response = new HashMap<>();
      response.put("errors", dataValidationErrorException.getErrors());
      return response;
  }

}