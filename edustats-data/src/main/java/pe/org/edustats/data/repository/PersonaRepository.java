package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import pe.org.edustats.data.model.Persona;

/**
 * Created by Jorge on 05/04/2016.
 */
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findByNuDocumentoAndTipoDocumentoIdTipoDocumento (String nuDocumento, String idTipoDocumento);
}
