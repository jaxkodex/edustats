package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 05/04/2016.
 */
public class CargoBean implements Serializable {
    private String coCargo;
    private String deCargo;

    public String getCoCargo() {
        return coCargo;
    }

    public void setCoCargo(String coCargo) {
        this.coCargo = coCargo;
    }

    public String getDeCargo() {
        return deCargo;
    }

    public void setDeCargo(String deCargo) {
        this.deCargo = deCargo;
    }
}
