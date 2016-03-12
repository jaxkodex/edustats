package pe.org.edustats.data.model;

import java.io.Serializable;

public class PlanillaId implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idPeriodoAcademico;
  private Integer idTrabajador;

  public Integer getIdPeriodoAcademico() {
    return idPeriodoAcademico;
  }

  public void setIdPeriodoAcademico(Integer idPeriodoAcademico) {
    this.idPeriodoAcademico = idPeriodoAcademico;
  }

  public Integer getIdTrabajador() {
    return idTrabajador;
  }

  public void setIdTrabajador(Integer idTrabajador) {
    this.idTrabajador = idTrabajador;
  }

}
