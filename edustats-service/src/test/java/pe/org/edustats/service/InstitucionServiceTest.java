package pe.org.edustats.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.org.edustats.data.bean.InstitucionEducativaBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class InstitucionServiceTest {
  @Autowired
  private InstitucionEducativaService institucionEducativaService;

  @Test
  public void consultaInstitucionesEducativaPorIdUsuario () {
    List<InstitucionEducativaBean> ies = institucionEducativaService.consultaInstitucionEducativaPorIdUsuario(1);
  }
}
