package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 06/04/2016.
 */
public class CicloBean implements Serializable {
    private Integer idCiclo;
    private String deCiclo;

    public String getDeCiclo() {
        return deCiclo;
    }

    public void setDeCiclo(String deCiclo) {
        this.deCiclo = deCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }
}
