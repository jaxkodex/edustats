package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 06/04/2016.
 */
public class CursoBean implements Serializable {
    private Integer idCurso;
    private String deCurso;
    private GradoBean grado;

    public String getDeCurso() {
        return deCurso;
    }

    public void setDeCurso(String deCurso) {
        this.deCurso = deCurso;
    }

    public GradoBean getGrado() {
        return grado;
    }

    public void setGrado(GradoBean grado) {
        this.grado = grado;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
