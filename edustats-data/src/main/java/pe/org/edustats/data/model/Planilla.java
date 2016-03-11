package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planilla")
public class Planilla implements Serializable {
  private static final long serialVersionUID = 1L;
  private PeriodoAcademico periodoAcademico;
  private Trabajador trabajador;

  @ManyToOne
  @JoinColumn(name = "id_periodo_academico")
  public PeriodoAcademico getPeriodoAcademico() {
    return periodoAcademico;
  }

  public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
    this.periodoAcademico = periodoAcademico;
  }
  
  @ManyToOne
  @JoinColumn(name = "id_trabajador")
  public Trabajador getTrabajador() {
    return trabajador;
  }

  public void setTrabajador(Trabajador trabajador) {
    this.trabajador = trabajador;
  }
}
