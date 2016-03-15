package pe.org.edustats.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.service.PeriodoAcademicoService;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

@RestController
public class PeriodoAcademicoApiController {
  @Autowired
  private PeriodoAcademicoService periodoAcademicoService;
  
  @RequestMapping(value = "/api/periodoAcademico", method = RequestMethod.GET)
  public ResponseEntity<List<PeriodoAcademicoBean>> consulta (@RequestParam Integer idInstitucionEducativa) {
    List<PeriodoAcademicoBean> data = periodoAcademicoService.consultaPorInstitucionEducativa(idInstitucionEducativa);
    return new ResponseEntity<List<PeriodoAcademicoBean>>(data, HttpStatus.OK);
  }
  
  @RequestMapping(value = "/api/periodoAcademico/{idInstitucionEducativa}", method = RequestMethod.GET)
  public ResponseEntity<PeriodoAcademicoBean> consultaPorId (@PathVariable Integer idPeriodoAcademico) {
    PeriodoAcademicoBean periodoAcademicoBean = periodoAcademicoService.consultaPorId(idPeriodoAcademico);
    return new ResponseEntity<PeriodoAcademicoBean>(periodoAcademicoBean, HttpStatus.OK);
  }

  @Secured("ROLE_CONFPA")
  @RequestMapping(value = "/api/periodoAcademico", method = RequestMethod.POST)
  public ResponseEntity<PeriodoAcademicoBean> aperturarPeriodoAcademico(@RequestBody PeriodoAcademicoBean periodoAcademicoBean) throws ApplicationException, DataValidationException {
    periodoAcademicoBean = periodoAcademicoService.aperturarPeriodoAcademico(periodoAcademicoBean.getCoPeriodoAcademico(),
        periodoAcademicoBean.getFeInicio(),
        periodoAcademicoBean.getInstitucionEducativa());
    return new ResponseEntity<PeriodoAcademicoBean>(periodoAcademicoBean, HttpStatus.CREATED);
  }

}
