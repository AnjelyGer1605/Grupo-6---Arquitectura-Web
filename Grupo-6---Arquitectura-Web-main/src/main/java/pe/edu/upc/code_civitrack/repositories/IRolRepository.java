package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    // Buscar rol por nombre
    Rol findByNombreRol(String nombreRol);
}

