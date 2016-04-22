package pe.org.edustats.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import pe.org.edustats.data.bean.GradoBean;
import pe.org.edustats.service.GradoService;

/**
 * Created by Jorge on 22/04/2016.
 */
@RestController
public class GradoApiController {
    @Autowired
    private GradoService gradoService;

    @RequestMapping(value = "/api/grado", method = RequestMethod.GET)
    public ResponseEntity<List<GradoBean>> listar () {
        return new ResponseEntity<>(gradoService.listar(), HttpStatus.OK);
    }
}
