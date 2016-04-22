package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.CursoBean;
import pe.org.edustats.data.model.Curso;

/**
 * Created by Jorge on 06/04/2016.
 */
public class CursoModelToBeanConverter extends AbstractDataConverter<Curso, CursoBean> {
    @Override
    public CursoBean convert(Curso curso) {
        if (curso == null) {
            return null;
        }
        GradoModelToBeanConverter gradoModelToBeanConverter = new GradoModelToBeanConverter();
        CursoBean cursoBean = new CursoBean();

        cursoBean.setIdCurso(curso.getIdCurso());
        cursoBean.setDeCurso(curso.getDeCurso());

        return cursoBean;
    }
}
