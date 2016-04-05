package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.data.model.Persona;
import pe.org.edustats.data.model.Trabajador;

/**
 * Created by Jorge on 05/04/2016.
 */
public class TrabajadorBeanToModelConverter extends AbstractDataConverter<TrabajadorBean, Trabajador> {
    @Override
    public Trabajador convert(TrabajadorBean trabajadorBean) {
        if (trabajadorBean == null) {
            return null;
        }

        Trabajador trabajador = new Trabajador();
        trabajador.setIdTrabajador(trabajadorBean.getIdTrabajador());
        return trabajador;
    }
}
