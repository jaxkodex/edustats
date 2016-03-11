package pe.org.edustats.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
