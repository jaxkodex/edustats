package pe.org.edustats.service;

import java.util.Date;
import java.util.List;

import pe.org.edustats.data.bean.InstitucionEducativaBean;
import pe.org.edustats.data.bean.PeriodoAcademicoBean;
import pe.org.edustats.data.bean.PlanillaBean;
import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.service.exception.ApplicationException;
import pe.org.edustats.service.exception.DataValidationException;

public interface PeriodoAcademicoService {

    List<PeriodoAcademicoBean> consultaPorInstitucionEducativa(Integer idInstitucionEducativa);

    PeriodoAcademicoBean consultaPorId(Integer idPeriodoAcademico);

    PeriodoAcademicoBean aperturarPeriodoAcademico(String coPeriodoAcademico, Date feInicio, InstitucionEducativaBean institucionEducativaBean) throws ApplicationException, DataValidationException;

    /**
     * Verifica si existe periodo academico aperturado para la institucion educativa
     *
     * @param idInstitucionEducativa a consultar
     * @return true si existen periodos aperturados, false en caso contrario
     */
    boolean hayPeriodoAcademicoAperturado(Integer idInstitucionEducativa);

    /**
     * Agrega un docente a la plana del colegio para este periodo
     * @param idPeriodoAcademico perido en el que se incorpora el docente
     * @param trabajadorBean trabajador que es agregado a la plana
     * @throws DataValidationException cuando se requiere registrar el docente pero no se puede
     */
    PlanillaBean addDocenteAPlanaPeriodo (Integer idPeriodoAcademico, TrabajadorBean trabajadorBean) throws DataValidationException;

    /**
     * Carga la planilla de una institucion educativa para un periodo academico
     * @param idPeriodoAcademico que se consulta
     * @return lista de la planilla.
     */
    List<PlanillaBean> cargarPlanilla (Integer idPeriodoAcademico);
}
