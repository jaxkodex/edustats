package pe.org.edustats.service.util.enums;

/**
 * Created by Jorge on 05/04/2016.
 */
public enum CargoEnum {
    DOCENTE("DO"),
    DIRECTOR("DI");

    private final String coCargo;

    CargoEnum (String coCargo) {
        this.coCargo = coCargo;
    }

    public String getCoCargo() {
        return coCargo;
    }
}
