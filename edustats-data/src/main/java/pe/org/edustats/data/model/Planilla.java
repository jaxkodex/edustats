package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planilla")
@IdClass(PlanillaId.class)
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPeriodoAcademico;
    private Integer idTrabajador;
    private PeriodoAcademico periodoAcademico;
    private Trabajador trabajador;

    @Id
    @Column(name = "id_periodo_academico")
    public Integer getIdPeriodoAcademico() {
        return idPeriodoAcademico;
    }

    public void setIdPeriodoAcademico(Integer idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    @Id
    @Column(name = "id_trabajador")
    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @ManyToOne
    @JoinColumn(name = "id_periodo_academico", updatable = false, insertable = false)
    public PeriodoAcademico getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    @ManyToOne
    @JoinColumn(name = "id_trabajador", updatable = false, insertable = false)
    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
}
