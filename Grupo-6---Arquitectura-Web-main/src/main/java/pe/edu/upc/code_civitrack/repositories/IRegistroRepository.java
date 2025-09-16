package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Registro;

import java.util.List;

@Repository
public interface IRegistroRepository extends JpaRepository<Registro, Integer> {

    // Buscar registros por usuario
    List<Registro> findByUsuario_IdUsuario(int idUsuario);

    // Buscar registros por acción
    List<Registro> findByAccionContaining(String accion);
}


