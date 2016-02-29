package pe.org.edustats.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "institucion_educativa")
public class InstitucionEducativa implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idIntitucionEducativa;
  private Integer nuInstitucionEducativa;
  private String noInstitucionEducativa;
  private List<Usuario> usuarios;

  @Id
  @SequenceGenerator(name = "institucion_educativa_id_institucion_educativa_seq", sequenceName = "institucion_educativa_id_institucion_educativa_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institucion_educativa_id_institucion_educativa_seq")
  @Column(name = "id_institucion_educativa")
  public Integer getIdIntitucionEducativa() {
    return idIntitucionEducativa;
  }

  public void setIdIntitucionEducativa(Integer idIntitucionEducativa) {
    this.idIntitucionEducativa = idIntitucionEducativa;
  }

  @Column(name = "nu_institucion_educativa")
  public Integer getNuInstitucionEducativa() {
    return nuInstitucionEducativa;
  }

  public void setNuInstitucionEducativa(Integer nuInstitucionEducativa) {
    this.nuInstitucionEducativa = nuInstitucionEducativa;
  }

  @Column(name = "no_institucion_educativa")
  public String getNoInstitucionEducativa() {
    return noInstitucionEducativa;
  }

  public void setNoInstitucionEducativa(String noInstitucionEducativa) {
    this.noInstitucionEducativa = noInstitucionEducativa;
  }

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "institucionesEducativas")
  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
}
