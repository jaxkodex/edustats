package pe.org.edustats.web.controller.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.service.InstitucionEducativaService;

@RestController
public class InstitucionEducativaApiController {
  @Autowired
  private InstitucionEducativaService institucionEducativaService;

  @RequestMapping(value = "/api/ie", method = RequestMethod.GET)
  public List<InstitucionEducativaBean> listAll (Principal principal) {
    String noCuenta = principal.getName();
    return institucionEducativaService.consultaPorNoCuenta(noCuenta);
  }
}
