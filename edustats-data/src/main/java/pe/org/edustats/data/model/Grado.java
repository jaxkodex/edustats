package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Jorge on 06/04/2016.
 */
@Entity
@Table(name = "grado")
public class Grado implements Serializable {
    private Integer idGrado;
    private Integer nuGrado;
    private String deGrado;
    private Ciclo ciclo;

    @ManyToOne
    @JoinColumn(name = "id_ciclo")
    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    @Column(name = "de_grado")
    public String getDeGrado() {
        return deGrado;
    }

    public void setDeGrado(String deGrado) {
        this.deGrado = deGrado;
    }

    @Id
    @SequenceGenerator(name="grado_id_grado_seq", sequenceName="grado_id_grado_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="grado_id_grado_seq")
    @Column(name = "id_grado")
    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    @Column(name = "nu_grado")
    public Integer getNuGrado() {
        return nuGrado;
    }

    public void setNuGrado(Integer nuGrado) {
        this.nuGrado = nuGrado;
    }
}
