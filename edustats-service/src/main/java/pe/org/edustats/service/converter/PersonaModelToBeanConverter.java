package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.PersonaBean;
import pe.org.edustats.data.model.Persona;

public class PersonaModelToBeanConverter extends AbstractDataConverter<Persona, PersonaBean> {

  @Override
  public PersonaBean convert(Persona persona) {
    if (persona == null) {
      return null;
    }
    PersonaBean personaBean = new PersonaBean();
    personaBean.setAmPersona(persona.getAmPersona());
    personaBean.setApPersona(persona.getApPersona());
    personaBean.setFeNacimiento(persona.getFeNacimiento());
    personaBean.setIdPersona(persona.getIdPersona());
    personaBean.setNoPersona(persona.getNoPersona());
    personaBean.setNuDocumento(persona.getNuDocumento());
    return personaBean;
  }

}
