package pe.org.edustats.data.bean;

import java.io.Serializable;
import java.util.Date;

public class PersonaBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idPersona;
    private String noPersona;
    private String apPersona;
    private String amPersona;
    private Date feNacimiento;
    private String nuDocumento;
    private TipoDocumentoBean tipoDocumento;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNoPersona() {
        return noPersona;
    }

    public void setNoPersona(String noPersona) {
        this.noPersona = noPersona;
    }

    public String getApPersona() {
        return apPersona;
    }

    public void setApPersona(String apPersona) {
        this.apPersona = apPersona;
    }

    public String getAmPersona() {
        return amPersona;
    }

    public void setAmPersona(String amPersona) {
        this.amPersona = amPersona;
    }

    public Date getFeNacimiento() {
        return feNacimiento;
    }

    public void setFeNacimiento(Date feNacimiento) {
        this.feNacimiento = feNacimiento;
    }

    public String getNuDocumento() {
        return nuDocumento;
    }

    public void setNuDocumento(String nuDocumento) {
        this.nuDocumento = nuDocumento;
    }

    public TipoDocumentoBean getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoBean tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
