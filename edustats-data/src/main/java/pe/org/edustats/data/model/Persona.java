package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  private String nuDocumento;
  
  private TipoDocumento tipoDocumento;

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

  @Column(name = "no_persona")
  public String getNoPersona() {
    return noPersona;
  }

  public void setNoPersona(String noPersona) {
    this.noPersona = noPersona;
  }

  @Column(name = "ap_persona")
  public String getApPersona() {
    return apPersona;
  }

  public void setApPersona(String apPersona) {
    this.apPersona = apPersona;
  }

  @Column(name = "am_persona")
  public String getAmPersona() {
    return amPersona;
  }

  public void setAmPersona(String amPersona) {
    this.amPersona = amPersona;
  }

  @Column(name = "fe_nacimiento")
  public Date getFeNacimiento() {
    return feNacimiento;
  }

  public void setFeNacimiento(Date feNacimiento) {
    this.feNacimiento = feNacimiento;
  }

  @Column(name = "nu_documento")
  public String getNuDocumento() {
    return nuDocumento;
  }

  public void setNuDocumento(String nuDocumento) {
    this.nuDocumento = nuDocumento;
  }

  @ManyToOne
  @JoinColumn(name = "id_tipo_documento")
  public TipoDocumento getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(TipoDocumento tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }
}
