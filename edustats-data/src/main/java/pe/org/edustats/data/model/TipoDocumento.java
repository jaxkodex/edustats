package pe.org.edustats.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {
  private static final long serialVersionUID = 1L;
  private String idTipoDocumento;
  private String deCorta;
  private String deLarga;

  @Id
  @Column(name = "id_tipo_documento")
  public String getIdTipoDocumento() {
    return idTipoDocumento;
  }

  public void setIdTipoDocumento(String idTipoDocumento) {
    this.idTipoDocumento = idTipoDocumento;
  }

  @Column(name = "de_corta")
  public String getDeCorta() {
    return deCorta;
  }

  public void setDeCorta(String deCorta) {
    this.deCorta = deCorta;
  }

  @Column(name = "de_larga")
  public String getDeLarga() {
    return deLarga;
  }

  public void setDeLarga(String deLarga) {
    this.deLarga = deLarga;
  }

}
