package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import pe.org.edustats.data.model.Aula;

/**
 * Created by Jorge on 06/04/2016.
 */
public interface AulaRepository extends JpaRepository<Aula, Integer> {

    List<Aula> findByPeriodoAcademicoIdPeriodoAcademico (Integer idPeriodoAcademico);
}
