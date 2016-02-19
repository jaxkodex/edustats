package pe.org.edustats.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.org.edustats.data.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  
  public List<Usuario> findByNoCuenta (String noCuenta);

}
