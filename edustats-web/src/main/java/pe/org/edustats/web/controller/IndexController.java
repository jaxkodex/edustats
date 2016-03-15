package pe.org.edustats.web.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.web.utils.SessionVariables;

@Controller
public class IndexController {
  @Autowired
  private HttpSession session;
  @Value("${javascript.minified}")
  private Boolean isJavascriptMinified;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index (Model model, Principal principal) {
    UsuarioBean usuario = (UsuarioBean) session.getAttribute(SessionVariables.USUARIO_SESSION_VARIABLE);
    List<InstitucionEducativaBean> ies = (List<InstitucionEducativaBean>) session.getAttribute(SessionVariables.IES_SESSION_VARIABLE);
    ObjectMapper mapper = new ObjectMapper();
    try {
      model.addAttribute("userData", mapper.writeValueAsString(usuario));
      model.addAttribute("ies", mapper.writeValueAsString(ies));
    } catch (JsonProcessingException e) {}
    model.addAttribute("isJavascriptMinified", isJavascriptMinified);
    return "index";
  }
}
