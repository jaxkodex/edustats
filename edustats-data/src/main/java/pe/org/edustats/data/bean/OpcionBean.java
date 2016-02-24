package pe.org.edustats.data.bean;

public class OpcionBean {
  private Integer idOpcion;
  private String coOpcion;
  private String deOpcion;
  private String deRuta;
  private OpcionBean opcionPadre;

  public Integer getIdOpcion() {
    return idOpcion;
  }

  public void setIdOpcion(Integer idOpcion) {
    this.idOpcion = idOpcion;
  }

  public String getCoOpcion() {
    return coOpcion;
  }

  public void setCoOpcion(String coOpcion) {
    this.coOpcion = coOpcion;
  }

  public String getDeOpcion() {
    return deOpcion;
  }

  public void setDeOpcion(String deOpcion) {
    this.deOpcion = deOpcion;
  }

  public String getDeRuta() {
    return deRuta;
  }

  public void setDeRuta(String deRuta) {
    this.deRuta = deRuta;
  }

  public OpcionBean getOpcionPadre() {
    return opcionPadre;
  }

  public void setOpcionPadre(OpcionBean opcionPadre) {
    this.opcionPadre = opcionPadre;
  }
}
