package pe.org.edustats.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import pe.org.edustats.data.bean.UsuarioBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UsuarioServiceTest {
  @Autowired
  private UsuarioService usuarioService;

  @Test
  public void cargarUsuarioPorNoCuentaTest() {
    UsuarioBean usuarioBean = usuarioService.cargarPorNoCuenta("demo");
    Assert.assertNotNull(usuarioBean);
  }

}
