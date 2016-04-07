package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.GradoBean;
import pe.org.edustats.data.model.Grado;

/**
 * Created by Jorge on 06/04/2016.
 */
public class GradoModelToBeanConverter extends AbstractDataConverter<Grado, GradoBean> {
    @Override
    public GradoBean convert(Grado grado) {
        if (grado == null) {
            return null;
        }
        CicloModelToBeanConverter cicloModelToBeanConverter;
        cicloModelToBeanConverter = new CicloModelToBeanConverter();

        GradoBean gradoBean = new GradoBean();

        gradoBean.setIdGrado(grado.getIdGrado());
        gradoBean.setNuGrado(grado.getNuGrado());
        gradoBean.setDeGrado(grado.getDeGrado());

        gradoBean.setCiclo(cicloModelToBeanConverter.convert(grado.getCiclo()));

        return gradoBean;
    }
}
