package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.SeccionBean;
import pe.org.edustats.data.model.Seccion;

/**
 * Created by Jorge on 07/04/2016.
 */
public class SeccionBeanToModelConverter extends AbstractDataConverter<SeccionBean, Seccion> {
    @Override
    public Seccion convert(SeccionBean seccionBean) {
        if (seccionBean == null) {
            return null;
        }
        Seccion seccion = new Seccion();
        seccion.setCoSeccion(seccionBean.getCoSeccion());
        seccion.setDeSeccion(seccionBean.getDeSeccion());

        return seccion;
    }
}
