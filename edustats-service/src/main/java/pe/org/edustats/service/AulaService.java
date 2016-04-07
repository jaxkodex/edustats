package pe.org.edustats.service;

import java.util.List;

import pe.org.edustats.data.bean.AulaBean;
import pe.org.edustats.service.exception.DataValidationException;

/**
 * Created by Jorge on 07/04/2016.
 */
public interface AulaService {

    AulaBean cargar(Integer idAula);

    List<AulaBean> consultaPorPeriodoAcademico(Integer idPeriodoAcademico);

    AulaBean crear(AulaBean aulaBean) throws DataValidationException;
}
