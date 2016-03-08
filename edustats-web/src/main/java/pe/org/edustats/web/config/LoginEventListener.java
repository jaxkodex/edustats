package pe.org.edustats.web.config;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import pe.org.edustats.data.bean.UsuarioBean;
import pe.org.edustats.service.UsuarioService;
import pe.org.edustats.web.utils.SessionVariables;

@Component
public class LoginEventListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
  @Autowired
  private UsuarioService usuarioService;
  @Autowired
  private HttpSession session;

  @Override
  public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
    String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    UsuarioBean usuarioBean = usuarioService.cargarPorNoCuenta(username);
    session.setAttribute(SessionVariables.USUARIO_SESSION_VARIABLE, usuarioBean);
  }

}
