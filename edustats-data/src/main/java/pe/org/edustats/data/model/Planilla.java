package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "planilla")
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPlanilla;
    private PeriodoAcademico periodoAcademico;
    private Trabajador trabajador;

    @Id
    @SequenceGenerator(name="planilla_id_planilla_seq", sequenceName="planilla_id_planilla_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="planilla_id_planilla_seq")
    @Column(name = "id_planilla")
    public Integer getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

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
