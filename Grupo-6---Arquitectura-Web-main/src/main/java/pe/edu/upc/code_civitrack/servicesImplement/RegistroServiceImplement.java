package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Registro;
import pe.edu.upc.code_civitrack.repositories.IRegistroRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IRegistroService;

import java.util.List;

@Service
public class RegistroServiceImplement implements IRegistroService {
    @Autowired
    private IRegistroRepository rR;

    @Override
    public List<Registro> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Registro registro) {
        rR.save(registro);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Registro listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Registro registro) {
        rR.save(registro);
    }

    @Override
    public List<Registro> findByUsuario(int idUsuario) {
        return rR.findByUsuario_IdUsuario(idUsuario);
    }

    @Override
    public List<Registro> findByAccion(String accion) {
        return rR.findByAccionContaining(accion);
    }
}

