package pe.org.edustats.data.bean;

import java.io.Serializable;
import java.util.Date;

public class PersonaBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idPersona;
  private String noPersona;
  private String apPersona;
  private String amPersona;
  private Date feNacimiento;

  public Integer getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Integer idPersona) {
    this.idPersona = idPersona;
  }

  public String getNoPersona() {
    return noPersona;
  }

  public void setNoPersona(String noPersona) {
    this.noPersona = noPersona;
  }

  public String getApPersona() {
    return apPersona;
  }

  public void setApPersona(String apPersona) {
    this.apPersona = apPersona;
  }

  public String getAmPersona() {
    return amPersona;
  }

  public void setAmPersona(String amPersona) {
    this.amPersona = amPersona;
  }

  public Date getFeNacimiento() {
    return feNacimiento;
  }

  public void setFeNacimiento(Date feNacimiento) {
    this.feNacimiento = feNacimiento;
  }

}
