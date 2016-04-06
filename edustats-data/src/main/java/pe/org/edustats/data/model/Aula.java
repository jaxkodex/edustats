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
@Table(name = "aula")
public class Aula implements Serializable {
    private Integer idAula;
    private Grado grado;
    private Seccion seccion;
    private PeriodoAcademico periodoAcademico;

    @ManyToOne
    @JoinColumn(name = "id_grado")
    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    @Id
    @SequenceGenerator(name="aula_id_aula_seq", sequenceName="aula_id_aula_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="aula_id_aula_seq")
    @Column(name = "id_aula")
    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    @ManyToOne
    @JoinColumn(name = "id_periodo_academico")
    public PeriodoAcademico getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    @ManyToOne
    @JoinColumn(name = "id_seccion")
    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
}
