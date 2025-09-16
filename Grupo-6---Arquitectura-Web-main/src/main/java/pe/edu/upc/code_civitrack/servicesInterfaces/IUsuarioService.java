package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void delete(int id);
    public Usuario listId(int id);
    public void update(Usuario usuario);

    // Métodos adicionales
    public Usuario findByCorreo(String correo);
    public List<Usuario> findByRol(int idRol);
}

