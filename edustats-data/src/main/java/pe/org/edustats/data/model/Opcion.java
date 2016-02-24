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

@Entity
@Table(name = "opcion")
public class Opcion implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer idOpcion;
  private String coOpcion;
  private String deOpcion;
  private String deRuta;
  private Opcion opcionPadre;

  @Id
  @SequenceGenerator(name = "opcion_id_opcion_seq", sequenceName = "opcion_id_opcion_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opcion_id_opcion_seq")
  @Column(name = "id_opcion")
  public Integer getIdOpcion() {
    return idOpcion;
  }

  public void setIdOpcion(Integer idOpcion) {
    this.idOpcion = idOpcion;
  }

  @Column(name = "co_opcion")
  public String getCoOpcion() {
    return coOpcion;
  }

  public void setCoOpcion(String coOpcion) {
    this.coOpcion = coOpcion;
  }

  @Column(name = "de_opcion")
  public String getDeOpcion() {
    return deOpcion;
  }

  public void setDeOpcion(String deOpcion) {
    this.deOpcion = deOpcion;
  }

  @Column(name = "de_ruta")
  public String getDeRuta() {
    return deRuta;
  }

  public void setDeRuta(String deRuta) {
    this.deRuta = deRuta;
  }

  @ManyToOne
  @JoinColumn(name = "id_opcion_padre")
  public Opcion getOpcionPadre() {
    return opcionPadre;
  }

  public void setOpcionPadre(Opcion opcionPadre) {
    this.opcionPadre = opcionPadre;
  }

}
