package pe.org.edustats.service;

import java.util.List;

import pe.org.edustats.data.bean.InstitucionEducativaBean;

public interface InstitucionEducativaService {

  public List<InstitucionEducativaBean> consultaInstitucionEducativaPorIdUsuario (Integer idUsuario);
}
