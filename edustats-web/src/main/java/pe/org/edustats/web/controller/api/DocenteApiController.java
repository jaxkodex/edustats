package pe.org.edustats.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.service.DocenteService;
import pe.org.edustats.service.exception.DataValidationException;

/**
 * Created by Jorge on 05/04/2016.
 */
@RestController
public class DocenteApiController {
    @Autowired
    private DocenteService docenteService;
    private static final String CONSULTA_POR_NU_DOCUMENTO = "nuDocumento";

    @RequestMapping(value = "/api/docente", method = RequestMethod.GET)
    public ResponseEntity<List<TrabajadorBean>> consulta (@RequestParam(required = false, defaultValue = "") String by,
                                                          @RequestParam(required = false) String nuDocumento) {
        List<TrabajadorBean> trabajadores = new ArrayList<>();
        switch (by) {
            case CONSULTA_POR_NU_DOCUMENTO:
                trabajadores = docenteService.consultaPorNuDocumento(nuDocumento);
                break;
        }
        return new ResponseEntity<>(trabajadores, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/docente", method = RequestMethod.POST)
    public ResponseEntity<TrabajadorBean> crear (@RequestBody TrabajadorBean trabajadorBean) throws DataValidationException {
        return new ResponseEntity<>(docenteService.create(trabajadorBean), HttpStatus.CREATED);
    }
}
