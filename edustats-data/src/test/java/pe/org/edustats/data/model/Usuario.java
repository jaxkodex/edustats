package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author JaxKodex
 *
 */
@Entity
public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idUsuario;
  private String noCuenta;
  private String coContrasenia;
  private Persona persona;
  private List<Rol> roles = new ArrayList<>();

  @Id
  @SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "usuario_id_usuario_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_usuario_seq")
  @Column(name = "id_usuario")
  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  @Column(name = "no_cuenta", unique = true)
  public String getNoCuenta() {
    return noCuenta;
  }

  public void setNoCuenta(String noCuenta) {
    this.noCuenta = noCuenta;
  }

  /**
   * hash de contrasenia MD5
   * 
   * @return contrasenia guardada
   */
  @Column(name = "co_constrasenia")
  public String getCoContrasenia() {
    return coContrasenia;
  }

  public void setCoContrasenia(String coContrasenia) {
    this.coContrasenia = coContrasenia;
  }

  @ManyToOne
  @JoinColumn(name = "id_persona")
  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "usuario_rol",
      joinColumns = {@JoinColumn(name = "id_usuario", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "id_rol", nullable = false, updatable = false)})
  public List<Rol> getRoles() {
    return roles;
  }

  public void setRoles(List<Rol> roles) {
    this.roles = roles;
  }

}
