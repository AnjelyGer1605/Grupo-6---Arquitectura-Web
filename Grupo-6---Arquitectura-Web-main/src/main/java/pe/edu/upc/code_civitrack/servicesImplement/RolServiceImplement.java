package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Rol;
import pe.edu.upc.code_civitrack.repositories.IRolRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public Rol findByNombre(String nombreRol) {
        return rR.findByNombreRol(nombreRol);
    }
}
