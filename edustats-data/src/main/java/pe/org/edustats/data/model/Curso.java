package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Jorge on 06/04/2016.
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    private Integer idCurso;
    private String deCurso;

    @Column(name = "de_curso")
    public String getDeCurso() {
        return deCurso;
    }

    public void setDeCurso(String deCurso) {
        this.deCurso = deCurso;
    }

    @Id
    @SequenceGenerator(name="curso_id_curso_seq", sequenceName="curso_id_curso_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="curso_id_curso_seq")
    @Column(name = "id_curso")
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
