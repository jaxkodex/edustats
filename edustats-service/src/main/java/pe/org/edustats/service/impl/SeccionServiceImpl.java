package pe.org.edustats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import pe.org.edustats.data.bean.SeccionBean;
import pe.org.edustats.data.model.Seccion;
import pe.org.edustats.data.repository.SeccionRepository;
import pe.org.edustats.service.SeccionService;
import pe.org.edustats.service.converter.SeccionModelToBeanConverter;

/**
 * Created by Jorge on 08/04/2016.
 */
@Service
public class SeccionServiceImpl implements SeccionService {
    @Autowired
    private SeccionRepository seccionRepository;

    @Override
    public List<SeccionBean> listar() {
        List<Seccion> secciones = seccionRepository.findAll();
        return new SeccionModelToBeanConverter().convertList(secciones);
    }
}
