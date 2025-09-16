package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Registro;
import java.util.List;

public interface IRegistroService {
    public List<Registro> list();
    public void insert(Registro registro);
    public void delete(int id);
    public Registro listId(int id);
    public void update(Registro registro);

    // Métodos adicionales
    public List<Registro> findByUsuario(int idUsuario);
    public List<Registro> findByAccion(String accion);
}

