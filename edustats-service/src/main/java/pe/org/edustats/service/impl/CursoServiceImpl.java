package pe.org.edustats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.org.edustats.data.bean.CursoBean;
import pe.org.edustats.data.model.Curso;
import pe.org.edustats.data.repository.CursoRepository;
import pe.org.edustats.service.CursoService;
import pe.org.edustats.service.converter.CursoModelToBeanConverter;

/**
 * Created by Jorge on 06/04/2016.
 */
@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoBean> listarCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return new CursoModelToBeanConverter().convertList(cursos);
    }
}
