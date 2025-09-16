package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Usuario;
import pe.edu.upc.code_civitrack.repositories.IUsuarioRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;


    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return uR.findByCorreo(correo);
    }

    @Override
    public List<Usuario> findByRol(int idRol) {
        return uR.findByRol_IdRol(idRol);
    }
}
