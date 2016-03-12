package pe.org.edustats.data.bean;

import java.io.Serializable;
import java.util.Date;

public class PeriodoAcademicoBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idPeriodoAcademico;
  private String coPeriodoAcademico;
  private Date feInicio;
  private Date feFin;
  private Date feCierre;
  private InstitucionEducativaBean institucionEducativaBean;

  public Integer getIdPeriodoAcademico() {
    return idPeriodoAcademico;
  }

  public void setIdPeriodoAcademico(Integer idPeriodoAcademico) {
    this.idPeriodoAcademico = idPeriodoAcademico;
  }

  public String getCoPeriodoAcademico() {
    return coPeriodoAcademico;
  }

  public void setCoPeriodoAcademico(String coPeriodoAcademico) {
    this.coPeriodoAcademico = coPeriodoAcademico;
  }

  public Date getFeInicio() {
    return feInicio;
  }

  public void setFeInicio(Date feInicio) {
    this.feInicio = feInicio;
  }

  public Date getFeFin() {
    return feFin;
  }

  public void setFeFin(Date feFin) {
    this.feFin = feFin;
  }

  public Date getFeCierre() {
    return feCierre;
  }

  public void setFeCierre(Date feCierre) {
    this.feCierre = feCierre;
  }

  public InstitucionEducativaBean getInstitucionEducativaBean() {
    return institucionEducativaBean;
  }

  public void setInstitucionEducativaBean(InstitucionEducativaBean institucionEducativaBean) {
    this.institucionEducativaBean = institucionEducativaBean;
  }

}
