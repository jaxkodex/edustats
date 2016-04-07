package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.CicloBean;
import pe.org.edustats.data.bean.GradoBean;
import pe.org.edustats.data.model.Ciclo;
import pe.org.edustats.data.model.Grado;

/**
 * Created by Jorge on 07/04/2016.
 */
public class GradoBeanToModelConverter extends AbstractDataConverter<GradoBean, Grado> {
    @Override
    public Grado convert(GradoBean gradoBean) {
        if (gradoBean == null) {
            return null;
        }
        Grado grado = new Grado();

        grado.setIdGrado(grado.getIdGrado());
        grado.setNuGrado(grado.getNuGrado());
        grado.setDeGrado(grado.getDeGrado());

        grado.setCiclo(new Ciclo());
        grado.getCiclo().setIdCiclo(gradoBean.getCiclo().getIdCiclo());

        return grado;
    }
}
