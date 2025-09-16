package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Rol;
import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol rol);
    public void delete(int id);
    public Rol listId(int id);
    public void update(Rol rol);

    // Método adicional
    public Rol findByNombre(String nombreRol);
}

