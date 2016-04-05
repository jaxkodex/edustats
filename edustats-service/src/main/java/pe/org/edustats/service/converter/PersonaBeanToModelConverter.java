package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.PersonaBean;
import pe.org.edustats.data.model.Persona;
import pe.org.edustats.data.model.TipoDocumento;

/**
 * Created by Jorge on 05/04/2016.
 */
public class PersonaBeanToModelConverter extends AbstractDataConverter<PersonaBean, Persona> {
    @Override
    public Persona convert(PersonaBean personaBean) {
        if (personaBean == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setAmPersona(personaBean.getAmPersona());
        persona.setApPersona(personaBean.getApPersona());
        persona.setFeNacimiento(personaBean.getFeNacimiento());
        persona.setIdPersona(personaBean.getIdPersona());
        persona.setNoPersona(personaBean.getNoPersona());
        persona.setNuDocumento(personaBean.getNuDocumento());

        persona.setTipoDocumento(new TipoDocumento());
        persona.getTipoDocumento().setIdTipoDocumento(personaBean.getTipoDocumento().getIdTipoDocumento());
        return persona;
    }
}
