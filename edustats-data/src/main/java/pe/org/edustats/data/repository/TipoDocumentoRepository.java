package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, String> {

}
