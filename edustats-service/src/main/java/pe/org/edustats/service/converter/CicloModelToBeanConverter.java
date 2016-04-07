package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.CicloBean;
import pe.org.edustats.data.model.Ciclo;

/**
 * Created by Jorge on 06/04/2016.
 */
public class CicloModelToBeanConverter extends AbstractDataConverter<Ciclo, CicloBean> {

    @Override
    public CicloBean convert(Ciclo ciclo) {
        if (ciclo == null) {
            return null;
        }

        CicloBean cicloBean = new CicloBean();
        cicloBean.setIdCiclo(ciclo.getIdCiclo());
        cicloBean.setDeCiclo(ciclo.getDeCiclo());

        return cicloBean;
    }
}
