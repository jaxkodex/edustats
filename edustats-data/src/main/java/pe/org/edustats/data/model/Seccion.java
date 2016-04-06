package pe.org.edustats.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jorge on 06/04/2016.
 */
@Entity
@Table(name = "seccion")
public class Seccion {
    private String coSeccion;
    private String deSeccion;

    @Id
    @Column(name = "co_seccion")
    public String getCoSeccion() {
        return coSeccion;
    }

    public void setCoSeccion(String coSeccion) {
        this.coSeccion = coSeccion;
    }

    @Column(name = "de_seccion")
    public String getDeSeccion() {
        return deSeccion;
    }

    public void setDeSeccion(String deSeccion) {
        this.deSeccion = deSeccion;
    }
}
