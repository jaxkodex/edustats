package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 06/04/2016.
 */
public class GradoBean implements Serializable {
    private Integer idGrado;
    private Integer nuGrado;
    private String deGrado;
    private CicloBean ciclo;

    public CicloBean getCiclo() {
        return ciclo;
    }

    public void setCiclo(CicloBean ciclo) {
        this.ciclo = ciclo;
    }

    public String getDeGrado() {
        return deGrado;
    }

    public void setDeGrado(String deGrado) {
        this.deGrado = deGrado;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Integer getNuGrado() {
        return nuGrado;
    }

    public void setNuGrado(Integer nuGrado) {
        this.nuGrado = nuGrado;
    }
}
