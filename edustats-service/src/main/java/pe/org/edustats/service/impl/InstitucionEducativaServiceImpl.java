package pe.org.edustats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.model.InstitucionEducativa;
import pe.org.edustats.data.model.Usuario;
import pe.org.edustats.data.repository.InstitucionEducativaRepository;
import pe.org.edustats.data.repository.UsuarioRepository;
import pe.org.edustats.service.InstitucionEducativaService;
import pe.org.edustats.service.converter.InstitucionEducativaBeanToModelConverter;
import pe.org.edustats.service.converter.InstitucionEducativaModelToBeanConverter;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.service.util.DataValidator;
import pe.org.edustats.service.validator.InstitucionEducativaBeanValidator;

@Service
public class InstitucionEducativaServiceImpl implements InstitucionEducativaService {
  @Autowired
  private InstitucionEducativaRepository institucionEducativaRepository;
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private MessageSource messageSource;

  @Override
  public List<InstitucionEducativaBean> consultaPorIdUsuario(Integer idUsuario) {
    InstitucionEducativaModelToBeanConverter converter;
    converter = new InstitucionEducativaModelToBeanConverter();
    List<InstitucionEducativa> ies;
    ies = institucionEducativaRepository.findByUsuariosIdUsuario(idUsuario);
    return converter.convertList(ies);
  }

  @Override
  public List<InstitucionEducativaBean> consultaPorNoCuenta(String noCuenta) {
    InstitucionEducativaModelToBeanConverter converter;
    converter = new InstitucionEducativaModelToBeanConverter();
    List<InstitucionEducativa> ies;
    ies = institucionEducativaRepository.findByUsuariosNoCuenta(noCuenta);
    return converter.convertList(ies);
  }

  @Override
  public InstitucionEducativaBean consultarPorId(Integer idInstitucionEducativa) {
    InstitucionEducativaModelToBeanConverter converter;
    converter = new InstitucionEducativaModelToBeanConverter();
    return converter.convert(institucionEducativaRepository.findOne(idInstitucionEducativa));
  }

  @Override
  @Transactional
  public InstitucionEducativaBean crear(InstitucionEducativaBean institucionEducativaBean,
      String username) throws ApplicationException, DataValidationException {
    List<Usuario> usuarios;
    Usuario usuario;
    DataValidator<InstitucionEducativaBean> beanValidator;
    InstitucionEducativaBeanToModelConverter converterToModel;
    InstitucionEducativaModelToBeanConverter converterToBean;
    InstitucionEducativa ie;

    usuarios = usuarioRepository.findByNoCuenta(username);
    if (usuarios.isEmpty()) {
      throw new ApplicationException(messageSource.getMessage("usuario.noencontrado",
          new Object[] {}, LocaleContextHolder.getLocale()));
    }
    usuario = usuarios.get(0);
    beanValidator = new DataValidator<InstitucionEducativaBean>(new InstitucionEducativaBeanValidator(), messageSource);
    beanValidator.validate(institucionEducativaBean);

    converterToModel = new InstitucionEducativaBeanToModelConverter();
    converterToBean = new InstitucionEducativaModelToBeanConverter();

    ie = converterToModel.convert(institucionEducativaBean);
    usuario.getInstitucionesEducativas().add(ie);

    institucionEducativaRepository.save(ie);
    return converterToBean.convert(ie);
  }

  @Override
  @Transactional
  public InstitucionEducativaBean actualizar (InstitucionEducativaBean institucionEducativaBean, Integer idUsuario) throws DataValidationException {
    DataValidator<InstitucionEducativaBean> beanValidator;
    InstitucionEducativaBeanToModelConverter converterToModel;
    InstitucionEducativaModelToBeanConverter converterToBean;
    InstitucionEducativa ie;
//    Usuario usuario;
    
//    usuario = usuarioRepository.findOne(idUsuario);
    
    beanValidator = new DataValidator<InstitucionEducativaBean>(new InstitucionEducativaBeanValidator(), messageSource);
    beanValidator.validate(institucionEducativaBean);

    converterToModel = new InstitucionEducativaBeanToModelConverter();
    converterToBean = new InstitucionEducativaModelToBeanConverter();

    ie = converterToModel.convert(institucionEducativaBean);

    institucionEducativaRepository.save(ie);
    return converterToBean.convert(ie);
  }

}
