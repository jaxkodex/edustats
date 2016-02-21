package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author JaxKodex
 *
 */
@Entity
public class Persona implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idPersona;
  private String noPersona;
  private String apPersona;
  private String amPersona;
  private Date feNacimiento;

  @Id
  @SequenceGenerator(name="persona_id_persona_seq", sequenceName="persona_id_persona_seq", allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="persona_id_persona_seq")  
  @Column(name = "id_persona")
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
