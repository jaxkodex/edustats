package pe.org.edustats.service;

import java.util.List;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

public interface InstitucionEducativaService {

  public List<InstitucionEducativaBean> consultaPorIdUsuario (Integer idUsuario);
  
  public List<InstitucionEducativaBean> consultaPorNoCuenta (String noCuenta);
  
  public InstitucionEducativaBean consultarPorId (Integer idInstitucionEducativa);

  public InstitucionEducativaBean crear (InstitucionEducativaBean institucionEducativaBean, String username) throws ApplicationException, DataValidationException;
  
  public InstitucionEducativaBean actualizar (InstitucionEducativaBean institucionEducativaBean, Integer idUsuario) throws ApplicationException, DataValidationException;
}
