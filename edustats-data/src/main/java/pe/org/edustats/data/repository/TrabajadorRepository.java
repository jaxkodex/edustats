package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import pe.org.edustats.data.model.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {

    List<Trabajador> findByPersonaNuDocumentoAndPersonaTipoDocumentoIdTipoDocumentoAndCargoCoCargo(String nuDocumento, String idTipoDocumento, String coCargo);

    List<Trabajador> findByPersonaIdPersonaAndCargoCoCargo(Integer idPersona, String coCargo);

}
