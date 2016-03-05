package pe.org.edustats.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class InstitucionServiceTest {
  @Autowired
  private InstitucionEducativaService institucionEducativaService;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void consultaInstitucionesEducativaPorIdUsuario () {
    List<InstitucionEducativaBean> ies = institucionEducativaService.consultaPorIdUsuario(1);
    System.out.println(String.format("Instituciones educativas: %d", ies.size()));
  }
  
   @Test
   public void shouldThrowValidationExceptionWhenNoName () throws ApplicationException, DataValidationException {
     InstitucionEducativaBean ie = new InstitucionEducativaBean();
     
     thrown.expect(DataValidationException.class);
     System.out.println(institucionEducativaService);
     
     institucionEducativaService.crear(ie, "demo");
   }
   
   @Test
   public void shouldCreateAnIe () throws ApplicationException, DataValidationException {
     InstitucionEducativaBean ie = new InstitucionEducativaBean();
     ie.setNoInstitucionEducativa("Santa Rosa del Sauce");
     ie.setNuInstitucionEducativa(170);
     
     InstitucionEducativaBean result = institucionEducativaService.crear(ie, "demo");
     
     Assert.assertNotNull(result.getIdInstitucionEducativa());
   }
}
