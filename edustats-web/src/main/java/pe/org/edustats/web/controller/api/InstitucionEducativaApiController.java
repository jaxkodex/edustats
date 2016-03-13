package pe.org.edustats.web.controller.api;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.service.InstitucionEducativaService;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;
import pe.org.edustats.web.utils.SessionVariables;

@RestController
public class InstitucionEducativaApiController {
  @Autowired
  private InstitucionEducativaService institucionEducativaService;
  @Autowired
  private HttpSession session;

  @RequestMapping(value = "/api/ie", method = RequestMethod.GET)
  public List<InstitucionEducativaBean> listAll (Principal principal) {
    String noCuenta = principal.getName();
    return institucionEducativaService.consultaPorNoCuenta(noCuenta);
  }

  @RequestMapping(value = "/api/ie/{idInstitucionEducativa}", method = RequestMethod.GET)
  public InstitucionEducativaBean consultaPorId (@PathVariable Integer idInstitucionEducativa) {
    return institucionEducativaService.consultarPorId(idInstitucionEducativa);
  }

  @Secured("ROLE_CONFIE")
  @RequestMapping(value = "/api/ie", method = RequestMethod.POST)
  public InstitucionEducativaBean crear (@RequestBody InstitucionEducativaBean institucionEducativaBean) throws ApplicationException, DataValidationException {
    UsuarioBean usuario = (UsuarioBean) session.getAttribute(SessionVariables.USUARIO_SESSION_VARIABLE);
    return institucionEducativaService.crear(institucionEducativaBean, usuario.getNoCuenta());
  }

  @Secured("ROLE_CONFIE")
  @RequestMapping(value = "/api/ie/{idInstitucionEducativa}", method = RequestMethod.PUT)
  public InstitucionEducativaBean actualizar (@RequestBody InstitucionEducativaBean institucionEducativaBean) throws ApplicationException, DataValidationException {
    UsuarioBean usuario = (UsuarioBean) session.getAttribute(SessionVariables.USUARIO_SESSION_VARIABLE);
    return institucionEducativaService.actualizar(institucionEducativaBean, usuario.getIdUsuario());
  }
  
}
