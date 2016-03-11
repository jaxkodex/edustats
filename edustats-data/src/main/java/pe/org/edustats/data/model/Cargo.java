package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
  private static final long serialVersionUID = 1L;
  private String coCargo;
  private String deCargo;

  @Id
  @Column(name = "co_cargo")
  public String getCoCargo() {
    return coCargo;
  }

  public void setCoCargo(String coCargo) {
    this.coCargo = coCargo;
  }

  @Column(name = "de_cargo")
  public String getDeCargo() {
    return deCargo;
  }

  public void setDeCargo(String deCargo) {
    this.deCargo = deCargo;
  }

}
