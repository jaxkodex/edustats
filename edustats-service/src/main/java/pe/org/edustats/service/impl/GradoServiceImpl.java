package pe.org.edustats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.org.edustats.data.bean.GradoBean;
import pe.org.edustats.data.model.Grado;
import pe.org.edustats.data.repository.GradoRepository;
import pe.org.edustats.service.GradoService;
import pe.org.edustats.service.converter.GradoModelToBeanConverter;

/**
 * Created by Jorge on 22/04/2016.
 */
@Service
public class GradoServiceImpl implements GradoService {
    @Autowired
    private GradoRepository gradoRepository;

    @Override
    public List<GradoBean> listar() {
        List<Grado> grados = gradoRepository.findAll();
        return new GradoModelToBeanConverter().convertList(grados);
    }
}
