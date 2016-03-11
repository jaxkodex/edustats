package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {

}
