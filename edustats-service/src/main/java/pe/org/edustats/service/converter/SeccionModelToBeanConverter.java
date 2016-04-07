package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.SeccionBean;
import pe.org.edustats.data.model.Seccion;

/**
 * Created by Jorge on 07/04/2016.
 */
public class SeccionModelToBeanConverter extends AbstractDataConverter<Seccion, SeccionBean> {
    @Override
    public SeccionBean convert(Seccion seccion) {
        if (seccion == null) {
            return null;
        }
        SeccionBean seccionBean = new SeccionBean();
        seccionBean.setCoSeccion(seccion.getCoSeccion());
        seccionBean.setDeSeccion(seccion.getDeSeccion());
        return seccionBean;
    }
}
