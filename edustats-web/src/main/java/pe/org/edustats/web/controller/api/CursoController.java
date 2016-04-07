package pe.org.edustats.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import pe.org.edustats.data.bean.CursoBean;
import pe.org.edustats.service.CursoService;

/**
 * Created by Jorge on 06/04/2016.
 */
@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @RequestMapping(value = "/api/cursos", method = RequestMethod.GET)
    public List<CursoBean> consultar () {
        return cursoService.listarCursos();
    }
}
