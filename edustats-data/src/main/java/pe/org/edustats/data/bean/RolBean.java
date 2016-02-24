package pe.org.edustats.data.bean;

import java.io.Serializable;
import java.util.List;

public class RolBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idRol;
  private String noRol;
  private List<OpcionBean> opciones;

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

  public List<OpcionBean> getOpciones() {
    return opciones;
  }

  public void setOpciones(List<OpcionBean> opciones) {
    this.opciones = opciones;
  }

}
