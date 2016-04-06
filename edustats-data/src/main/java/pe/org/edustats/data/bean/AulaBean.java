package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 06/04/2016.
 */
public class AulaBean implements Serializable {
    private Integer idAula;
    private GradoBean grado;
    private SeccionBean seccion;
    private PeriodoAcademicoBean periodoAcademico;

    public GradoBean getGrado() {
        return grado;
    }

    public void setGrado(GradoBean grado) {
        this.grado = grado;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public PeriodoAcademicoBean getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademicoBean periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public SeccionBean getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionBean seccion) {
        this.seccion = seccion;
    }
}
