package pe.org.edustats.data.bean;

import java.io.Serializable;

public class RolBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idRol;
  private String noRol;

  public Integer getIdRol() {
    return idRol;
  }

  public void setIdRol(Integer idRol) {
    this.idRol = idRol;
  }

  public String getNoRol() {
    return noRol;
  }

  public void setNoRol(String noRol) {
    this.noRol = noRol;
  }

}
