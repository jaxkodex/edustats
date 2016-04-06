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

import javax.xml.ws.Response;

import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.bean.PlanillaBean;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.service.PeriodoAcademicoService;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

@RestController
public class PeriodoAcademicoApiController {
    @Autowired
    private PeriodoAcademicoService periodoAcademicoService;

    @RequestMapping(value = "/api/periodoAcademico", method = RequestMethod.GET)
    public ResponseEntity<List<PeriodoAcademicoBean>> consulta(@RequestParam Integer idInstitucionEducativa) {
        List<PeriodoAcademicoBean> data = periodoAcademicoService.consultaPorInstitucionEducativa(idInstitucionEducativa);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/periodoAcademico/{idPeriodoAcademico}", method = RequestMethod.GET)
    public ResponseEntity<PeriodoAcademicoBean> consultaPorId(@PathVariable Integer idPeriodoAcademico) {
        PeriodoAcademicoBean periodoAcademicoBean = periodoAcademicoService.consultaPorId(idPeriodoAcademico);
        return new ResponseEntity<>(periodoAcademicoBean, HttpStatus.OK);
    }

    @Secured("ROLE_CONFPA")
    @RequestMapping(value = "/api/periodoAcademico", method = RequestMethod.POST)
    public ResponseEntity<PeriodoAcademicoBean> aperturarPeriodoAcademico(@RequestBody PeriodoAcademicoBean periodoAcademicoBean) throws ApplicationException, DataValidationException {
        periodoAcademicoBean = periodoAcademicoService.aperturarPeriodoAcademico(periodoAcademicoBean.getCoPeriodoAcademico(),
                periodoAcademicoBean.getFeInicio(),
                periodoAcademicoBean.getInstitucionEducativa());
        return new ResponseEntity<>(periodoAcademicoBean, HttpStatus.CREATED);
    }

    @Secured("ROLE_CONFPA")
    @RequestMapping(value = "/api/periodoAcademico/{idPeriodoAcademico}/docente/add")
    public ResponseEntity agregarDocentePlanillaPeriodoAcademico(@PathVariable Integer idPeriodoAcademico, @RequestBody TrabajadorBean trabajadorBean) throws DataValidationException {
        periodoAcademicoService.addDocenteAPlanaPeriodo(idPeriodoAcademico, trabajadorBean);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/api/periodoAcademico/{idPeriodoAcademico}/docente", method = RequestMethod.GET)
    public ResponseEntity<List<PlanillaBean>> cargarPlanaDocente (@PathVariable Integer idPeriodoAcademico) throws DataValidationException {
        return new ResponseEntity<>(periodoAcademicoService.cargarPlanilla(idPeriodoAcademico), HttpStatus.OK);
    }

    @Secured("ROLE_CONFPA")
    @RequestMapping(value = "/api/periodoAcademico/{idPeriodoAcademico}/docente", method = RequestMethod.POST)
    public ResponseEntity<PlanillaBean> crear (@PathVariable Integer idPeriodoAcademico, @RequestBody PlanillaBean planillaBean) throws DataValidationException {
        planillaBean = periodoAcademicoService.addDocenteAPlanaPeriodo(idPeriodoAcademico, planillaBean.getTrabajador());
        return new ResponseEntity<>(planillaBean, HttpStatus.OK);
    }

}
