package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trabajador")
public class Trabajador implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idTrabajador;
  private Cargo cargo;
  
  private Persona persona;

  @Id
  @SequenceGenerator(name="trabajador_id_trabajador_seq", sequenceName="trabajador_id_trabajador_seq", allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="trabajador_id_trabajador_seq")
  @Column(name = "id_trabajador")
  public Integer getIdTrabajador() {
    return idTrabajador;
  }

  public void setIdTrabajador(Integer idTrabajador) {
    this.idTrabajador = idTrabajador;
  }

  @ManyToOne
  @JoinColumn(name = "id_cargo")
  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  @ManyToOne
  @JoinColumn(name = "id_persona")
  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

}
