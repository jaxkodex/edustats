package pe.org.edustats.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import pe.org.edustats.data.bean.SeccionBean;
import pe.org.edustats.service.SeccionService;

/**
 * Created by Jorge on 08/04/2016.
 */
@RestController
public class SeccionApiController {
    @Autowired
    private SeccionService seccionService;

    @RequestMapping(value = "/api/seccion", method = RequestMethod.GET)
    public ResponseEntity<List<SeccionBean>> listar () {
        List<SeccionBean> secciones = seccionService.listar();
        return new ResponseEntity<>(secciones, HttpStatus.OK);
    }
}
