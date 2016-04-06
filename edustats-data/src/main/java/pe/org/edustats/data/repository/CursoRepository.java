package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.Curso;

/**
 * Created by Jorge on 06/04/2016.
 */
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
