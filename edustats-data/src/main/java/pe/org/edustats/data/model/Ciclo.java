package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Jorge on 06/04/2016.
 */
@Entity
@Table(name = "ciclo")
public class Ciclo implements Serializable {
    private Integer idCiclo;
    private String deCiclo;

    @Column(name = "de_ciclo")
    public String getDeCiclo() {
        return deCiclo;
    }

    public void setDeCiclo(String deCiclo) {
        this.deCiclo = deCiclo;
    }

    @Id
    @SequenceGenerator(name="ciclo_id_ciclo_seq", sequenceName="ciclo_id_ciclo_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ciclo_id_ciclo_seq")
    @Column(name = "id_ciclo")
    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }
}
