package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Rol implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idRol;
  private String noRol;

  @Id
  @SequenceGenerator(name="rol_id_rol_seq", sequenceName="rol_id_rol_seq", allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rol_id_rol_seq")  
  @Column(name = "id_rol")
  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  @Column(name = "no_rol")
  public String getNoRol() {
    return noRol;
  }

  public void setNoRol(String noRol) {
    this.noRol = noRol;
  }
}
