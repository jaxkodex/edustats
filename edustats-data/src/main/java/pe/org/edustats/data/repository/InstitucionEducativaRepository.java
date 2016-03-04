package pe.org.edustats.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.InstitucionEducativa;

public interface InstitucionEducativaRepository extends JpaRepository<InstitucionEducativa, Integer> {

  public List<InstitucionEducativa> findByUsuariosIdUsuario (Integer idUsuario);
}
