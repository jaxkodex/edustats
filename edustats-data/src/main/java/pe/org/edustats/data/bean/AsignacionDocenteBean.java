package pe.org.edustats.data.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jorge on 06/04/2016.
 */
public class AsignacionDocenteBean implements Serializable {    private Integer idAsignacionDocente;
    private Date feAsignacion;
    private PlanillaBean planilla;
    private AulaBean aula;
    private CursoBean curso;

    public AulaBean getAula() {
        return aula;
    }

    public void setAula(AulaBean aula) {
        this.aula = aula;
    }

    public CursoBean getCurso() {
        return curso;
    }

    public void setCurso(CursoBean curso) {
        this.curso = curso;
    }

    public Date getFeAsignacion() {
        return feAsignacion;
    }

    public void setFeAsignacion(Date feAsignacion) {
        this.feAsignacion = feAsignacion;
    }

    public Integer getIdAsignacionDocente() {
        return idAsignacionDocente;
    }

    public void setIdAsignacionDocente(Integer idAsignacionDocente) {
        this.idAsignacionDocente = idAsignacionDocente;
    }

    public PlanillaBean getPlanilla() {
        return planilla;
    }

    public void setPlanilla(PlanillaBean planilla) {
        this.planilla = planilla;
    }
}
