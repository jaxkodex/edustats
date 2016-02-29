package pe.org.edustats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.model.InstitucionEducativa;
import pe.org.edustats.data.repository.InstitucionEducativaRepository;
import pe.org.edustats.service.InstitucionEducativaService;
import pe.org.edustats.service.converter.InstitucionEducativaModelToBeanConverter;

@Service
public class InstitucionEducativaServiceImpl implements InstitucionEducativaService {
  @Autowired
  private InstitucionEducativaRepository institucionEducativaRepository;

  @Override
  public List<InstitucionEducativaBean> consultaInstitucionEducativaPorIdUsuario(Integer idUsuario) {
    InstitucionEducativaModelToBeanConverter converter = new InstitucionEducativaModelToBeanConverter();
    List<InstitucionEducativa> ies = institucionEducativaRepository.findByUsuariosIdUsuario(idUsuario);
    return converter.convertList(ies);
  }

}
