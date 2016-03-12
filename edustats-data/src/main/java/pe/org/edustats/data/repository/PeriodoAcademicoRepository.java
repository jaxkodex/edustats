package pe.org.edustats.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.PeriodoAcademico;

public interface PeriodoAcademicoRepository extends JpaRepository<PeriodoAcademico, Integer> {

  public List<PeriodoAcademico> findByInstitucionEducativaIdInstitucionEducativaAndFeFinIsNull(Integer idInstitucionEducativa);
}
