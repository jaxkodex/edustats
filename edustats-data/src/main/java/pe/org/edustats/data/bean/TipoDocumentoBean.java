package pe.org.edustats.data.bean;

import java.io.Serializable;

/**
 * Created by Jorge on 05/04/2016.
 */
public class TipoDocumentoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idTipoDocumento;
    private String deCorta;
    private String deLarga;

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDeCorta() {
        return deCorta;
    }

    public void setDeCorta(String deCorta) {
        this.deCorta = deCorta;
    }

    public String getDeLarga() {
        return deLarga;
    }

    public void setDeLarga(String deLarga) {
        this.deLarga = deLarga;
    }
}
