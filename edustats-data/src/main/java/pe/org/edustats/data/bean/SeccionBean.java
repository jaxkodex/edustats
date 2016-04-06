package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 06/04/2016.
 */
public class SeccionBean implements Serializable {
    private String coSeccion;
    private String deSeccion;

    public String getCoSeccion() {
        return coSeccion;
    }

    public void setCoSeccion(String coSeccion) {
        this.coSeccion = coSeccion;
    }

    public String getDeSeccion() {
        return deSeccion;
    }

    public void setDeSeccion(String deSeccion) {
        this.deSeccion = deSeccion;
    }
}
