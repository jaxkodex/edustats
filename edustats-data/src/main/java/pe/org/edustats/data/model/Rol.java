package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Rol implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idRol;
  private String noRol;
  private List<Opcion> opciones;

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
   
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "rol_opcion",
      joinColumns = {@JoinColumn(name = "id_rol", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "id_opcion", nullable = false, updatable = false)})
  public List<Opcion> getOpciones() {
    return opciones;
  }

  public void setOpciones(List<Opcion> opciones) {
    this.opciones = opciones;
  }
}
