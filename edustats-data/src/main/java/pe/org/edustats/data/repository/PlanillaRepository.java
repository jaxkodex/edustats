package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import pe.org.edustats.data.model.Planilla;

public interface PlanillaRepository extends JpaRepository<Planilla, Integer> {

    List<Planilla> findByPeriodoAcademicoIdPeriodoAcademico (Integer idPeriodoAcademico);

}
