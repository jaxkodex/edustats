package pe.org.edustats.service;

import java.util.List;

import pe.org.edustats.data.bean.TrabajadorBean;
import pe.org.edustats.service.exception.DataValidationException;

/**
 * Created by Jorge on 05/04/2016.
 */
public interface DocenteService {

    /**
     * Registra un nuevo trabajador en la bd
     * @param trabajadorBean que se desea registrar
     * @return trabajador registrado con un nuevo id
     * @throws DataValidationException cuando el objeto no es válido
     */
    TrabajadorBean create (TrabajadorBean trabajadorBean) throws DataValidationException;

    /**
     * Actualiza la información de un trabajador
     * @param trabajadorBean con la información que se desea actualizar
     * @return información del trabajador actualizada
     * @throws DataValidationException cuando el objeto no es válido
     */
    TrabajadorBean update (TrabajadorBean trabajadorBean) throws DataValidationException;

    List<TrabajadorBean> consultaPorNuDocumento (String nuDocumento, String idTipoDocumento);
}
