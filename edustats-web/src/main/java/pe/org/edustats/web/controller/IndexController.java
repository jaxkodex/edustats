package pe.org.edustats.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.service.UsuarioService;

@Controller
public class IndexController {
  @Autowired
  private UsuarioService usuarioService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index (Model model, Principal principal) {
    UsuarioBean usuarioBean = usuarioService.cargarUsuarioPorNoCuenta(principal.getName());
    ObjectMapper mapper = new ObjectMapper();
    try {
      model.addAttribute("userData", mapper.writeValueAsString(usuarioBean));
    } catch (JsonProcessingException e) {}
    return "index";
  }
}
