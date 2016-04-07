package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.AulaBean;
import pe.org.edustats.data.bean.GradoBean;
import pe.org.edustats.data.model.Aula;

/**
 * Created by Jorge on 07/04/2016.
 */
public class AulaBeanToModelConverter extends AbstractDataConverter<AulaBean, Aula> {
    @Override
    public Aula convert(AulaBean aulaBean) {
        if (aulaBean == null) {
            return null;
        }
        PeriodoAcademicoBeanToModelConverter periodoAcademicoBeanToModelConverter;
        GradoBeanToModelConverter gradoBeanToModelConverter;
        SeccionBeanToModelConverter seccionBeanToModelConverter;

        periodoAcademicoBeanToModelConverter = new PeriodoAcademicoBeanToModelConverter();
        gradoBeanToModelConverter = new GradoBeanToModelConverter();
        seccionBeanToModelConverter = new SeccionBeanToModelConverter();

        Aula aula = new Aula();
        aula.setIdAula(aulaBean.getIdAula());
        aula.setGrado(gradoBeanToModelConverter.convert(aulaBean.getGrado()));
        aula.setPeriodoAcademico(periodoAcademicoBeanToModelConverter.convert(aulaBean.getPeriodoAcademico()));
        aula.setSeccion(seccionBeanToModelConverter.convert(aulaBean.getSeccion()));
        return aula;
    }
}
