package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "periodo_academico")
public class PeriodoAcademico implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idPeriodoAcademico;
  private String coPeriodoAcademico;
  private Date feInicio;
  private Date feFin;
  
  private InstitucionEducativa institucionEducativa;

  @Id
  @SequenceGenerator(name="periodo_academico_id_periodo_academico_seq", sequenceName="periodo_academico_id_periodo_academico_seq", allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="periodo_academico_id_periodo_academico_seq")
  @Column(name = "id_periodo_academico")
  public Integer getIdPeriodoAcademico() {
    return idPeriodoAcademico;
  }

  public void setIdPeriodoAcademico(Integer idPeriodoAcademico) {
    this.idPeriodoAcademico = idPeriodoAcademico;
  }

  @Column(name = "co_periodo_academico")
  public String getCoPeriodoAcademico() {
    return coPeriodoAcademico;
  }

  public void setCoPeriodoAcademico(String coPeriodoAcademico) {
    this.coPeriodoAcademico = coPeriodoAcademico;
  }

  @Column(name = "fe_inicio")
  public Date getFeInicio() {
    return feInicio;
  }

  public void setFeInicio(Date feInicio) {
    this.feInicio = feInicio;
  }

  @Column(name = "fe_inicio")
  public Date getFeFin() {
    return feFin;
  }

  public void setFeFin(Date feFin) {
    this.feFin = feFin;
  }

  @ManyToOne
  @JoinColumn(name = "id_institucion_educativa")
  public InstitucionEducativa getInstitucionEducativa() {
    return institucionEducativa;
  }

  public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
    this.institucionEducativa = institucionEducativa;
  }
}
