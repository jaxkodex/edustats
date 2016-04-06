package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.PlanillaBean;
import pe.org.edustats.data.model.Planilla;

/**
 * Created by Jorge on 05/04/2016.
 */
public class PlanillaModelToBeanConverter extends AbstractDataConverter<Planilla, PlanillaBean> {
    @Override
    public PlanillaBean convert(Planilla planilla) {
        if (planilla == null) {
            return null;
        }
        TrabajadorModelToBeanConverter tModelToBean = new TrabajadorModelToBeanConverter();
        PlanillaBean planillaBean = new PlanillaBean();
        planillaBean.setIdPeriodoAcademico(planilla.getIdPeriodoAcademico());
        planillaBean.setTrabajador(tModelToBean.convert(planilla.getTrabajador()));
        return planillaBean;
    }
}
