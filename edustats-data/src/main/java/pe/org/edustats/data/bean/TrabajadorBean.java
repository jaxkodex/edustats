package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 05/04/2016.
 */
public class TrabajadorBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idTrabajador;
    private CargoBean cargo;

    private PersonaBean persona;

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public CargoBean getCargo() {
        return cargo;
    }

    public void setCargo(CargoBean cargo) {
        this.cargo = cargo;
    }

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }
}
