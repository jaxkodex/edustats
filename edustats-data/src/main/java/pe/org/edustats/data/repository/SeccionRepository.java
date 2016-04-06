package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.Seccion;

/**
 * Created by Jorge on 06/04/2016.
 */
public interface SeccionRepository extends JpaRepository<Seccion, String> {
}
