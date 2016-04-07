package pe.org.edustats.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import pe.org.edustats.data.bean.AulaBean;
import pe.org.edustats.service.AulaService;
import pe.org.edustats.service.exception.DataValidationException;

/**
 * Created by Jorge on 07/04/2016.
 */
@RestController
public class AulaApiController {
    @Autowired
    private AulaService aulaService;

    @RequestMapping(value = "/api/aula", method = RequestMethod.GET)
    public ResponseEntity<List<AulaBean>> consultar (@RequestParam(required = false) Integer idPeriodoAcademico) {
        List<AulaBean> data = new ArrayList<>();
        if (idPeriodoAcademico != null) {
            data = aulaService.consultaPorPeriodoAcademico(idPeriodoAcademico);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/aula/{idAula}", method = RequestMethod.GET)
    public ResponseEntity<AulaBean> cargar (@PathVariable Integer idAula) {
        return new ResponseEntity<>(aulaService.cargar(idAula), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/aula", method = RequestMethod.POST)
    public ResponseEntity<AulaBean> crear (@RequestBody AulaBean aulaBean) throws DataValidationException {
        aulaBean = aulaService.crear(aulaBean);
        return new ResponseEntity<>(aulaBean, HttpStatus.OK);
    }
}
