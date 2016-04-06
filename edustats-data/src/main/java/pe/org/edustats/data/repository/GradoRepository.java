package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.Grado;

/**
 * Created by Jorge on 06/04/2016.
 */
public interface GradoRepository extends JpaRepository<Grado, Integer> {
}
