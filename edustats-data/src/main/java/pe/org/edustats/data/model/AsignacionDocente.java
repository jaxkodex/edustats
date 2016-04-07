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

/**
 * Created by Jorge on 06/04/2016.
 */
@Entity
@Table(name = "asignacion_docente")
public class AsignacionDocente implements Serializable {
    private Integer idAsignacionDocente;
    private Date feAsignacion;
    private Planilla planilla;
    private Aula aula;
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @ManyToOne
    @JoinColumn(name = "id_curso")
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Column(name = "fe_asignacion")
    public Date getFeAsignacion() {
        return feAsignacion;
    }

    public void setFeAsignacion(Date feAsignacion) {
        this.feAsignacion = feAsignacion;
    }

    @Id
    @SequenceGenerator(name="asignacion_docente_id_asignacion_docente_seq", sequenceName="asignacion_docente_id_asignacion_docente_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="asignacion_docente_id_asignacion_docente_seq")
    @Column(name = "id_asignacion_docente")
    public Integer getIdAsignacionDocente() {
        return idAsignacionDocente;
    }

    public void setIdAsignacionDocente(Integer idAsignacionDocente) {
        this.idAsignacionDocente = idAsignacionDocente;
    }

    @ManyToOne
    @JoinColumn(name = "id_planilla")
    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }
}
