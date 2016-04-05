package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 05/04/2016.
 */
public class PlanillaBean implements Serializable {
    private Integer idPeriodoAcademico;
    private TrabajadorBean trabajador;

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
