package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.data.model.Trabajador;

/**
 * Created by Jorge on 05/04/2016.
 */
public class TrabajadorModelToBeanConverter extends AbstractDataConverter<Trabajador, TrabajadorBean> {
    @Override
    public TrabajadorBean convert(Trabajador trabajador) {
        if (trabajador == null) {
            return null;
        }
        CargoModelToBeanConverter cToBeanConverter;
        PersonaModelToBeanConverter pToBeanConverter;

        cToBeanConverter = new CargoModelToBeanConverter();
        pToBeanConverter = new PersonaModelToBeanConverter();

        TrabajadorBean trabajadorBean = new TrabajadorBean();
        trabajadorBean.setIdTrabajador(trabajador.getIdTrabajador());
        trabajadorBean.setCargo(cToBeanConverter.convert(trabajador.getCargo()));
        trabajadorBean.setPersona(pToBeanConverter.convert(trabajador.getPersona()));
        return trabajadorBean;
    }
}
