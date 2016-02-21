package pe.org.edustats.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UsuarioBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idUsuario;
  private String noCuenta;
  private String coContrasenia;
  private PersonaBean persona;
  private List<RolBean> roles = new ArrayList<>();

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNoCuenta() {
    return noCuenta;
  }

  public void setNoCuenta(String noCuenta) {
    this.noCuenta = noCuenta;
  }

  public String getCoContrasenia() {
    return coContrasenia;
  }

  public void setCoContrasenia(String coContrasenia) {
    this.coContrasenia = coContrasenia;
  }

  public PersonaBean getPersona() {
    return persona;
  }

  public void setPersona(PersonaBean persona) {
    this.persona = persona;
  }

  public List<RolBean> getRoles() {
    return roles;
  }

  public void setRoles(List<RolBean> roles) {
    this.roles = roles;
  }

}
