package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.AulaBean;
import pe.org.edustats.data.model.Aula;
import pe.org.edustats.data.model.Grado;
import pe.org.edustats.data.model.PeriodoAcademico;

/**
 * Created by Jorge on 07/04/2016.
 */
public class AulaModelToBeanConverter extends AbstractDataConverter<Aula, AulaBean> {
    @Override
    public AulaBean convert(Aula aula) {
        if (aula == null) {
            return null;
        }
        GradoModelToBeanConverter gradoModelToBeanConverter = new GradoModelToBeanConverter();
        SeccionModelToBeanConverter seccionModelToBeanConverter = new SeccionModelToBeanConverter();
        PeriodoAcademicoModelToBeanConverter periodoAcademicoModelToBeanConverter;
        periodoAcademicoModelToBeanConverter = new PeriodoAcademicoModelToBeanConverter();

        AulaBean aulaBean = new AulaBean();
        aulaBean.setIdAula(aula.getIdAula());
        aulaBean.setGrado(gradoModelToBeanConverter.convert(aula.getGrado()));
        aulaBean.setSeccion(seccionModelToBeanConverter.convert(aula.getSeccion()));
        aulaBean.setPeriodoAcademico(periodoAcademicoModelToBeanConverter.convert(aula.getPeriodoAcademico()));
        return aulaBean;
    }
}
