package pe.org.edustats.data.bean;

import java.io.Serializable;

public class InstitucionEducativaBean implements Serializable {
  private Integer idInstitucionEducativa;
  private Integer nuInstitucionEducativa;
  private String noInstitucionEducativa;

  public Integer getIdInstitucionEducativa() {
    return idInstitucionEducativa;
  }

  public void setIdIntitucionEducativa(Integer idInstitucionEducativa) {
    this.idInstitucionEducativa = idInstitucionEducativa;
  }

  public Integer getNuInstitucionEducativa() {
    return nuInstitucionEducativa;
  }

  public void setNuInstitucionEducativa(Integer nuInstitucionEducativa) {
    this.nuInstitucionEducativa = nuInstitucionEducativa;
  }

  public String getNoInstitucionEducativa() {
    return noInstitucionEducativa;
  }

  public void setNoInstitucionEducativa(String noInstitucionEducativa) {
    this.noInstitucionEducativa = noInstitucionEducativa;
  }

}
