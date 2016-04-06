package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 05/04/2016.
 */
public class PlanillaBean implements Serializable {
    private Integer idPlanilla;
    private Integer idPeriodoAcademico;
    private TrabajadorBean trabajador;

    public Integer getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Integer getIdPeriodoAcademico() {
        return idPeriodoAcademico;
    }

    public void setIdPeriodoAcademico(Integer idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    public TrabajadorBean getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorBean trabajador) {
        this.trabajador = trabajador;
    }
}
