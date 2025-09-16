package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.UsuarioDTO;
import pe.edu.upc.code_civitrack.entities.Usuario;
import pe.edu.upc.code_civitrack.servicesInterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
@Autowired
private IUsuarioService uS;

@GetMapping
public List<UsuarioDTO> listar() {
    return uS.list().stream().map(x -> {
        ModelMapper m = new ModelMapper();
        return m.map(x, UsuarioDTO.class);
    }).collect(Collectors.toList());
}
 @PostMapping
 public void insertar(@RequestBody UsuarioDTO dto) {
    ModelMapper m = new ModelMapper();
    Usuario u = m.map(dto, Usuario.class);
    uS.insert(u);
}
 @DeleteMapping("/{id}")
 public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
    Usuario usuario = uS.listId(id);
    if (usuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No existe un usuario con el ID: " + id);
    }
    uS.delete(id);
    return ResponseEntity.ok("Usuario eliminado correctamente.");
}
 @GetMapping("/{id}")
 public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
    Usuario usuario = uS.listId(id);
    if (usuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No existe un usuario con el ID: " + id);
    }
    ModelMapper m = new ModelMapper();
    UsuarioDTO dto = m.map(usuario, UsuarioDTO.class);
    return ResponseEntity.ok(dto);
}
 @PutMapping
 public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
    ModelMapper m = new ModelMapper();
    Usuario u = m.map(dto, Usuario.class);

    Usuario existente = uS.listId(u.getIdUsuario());
    if (existente == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No existe un usuario con el ID: " + u.getIdUsuario());
    }
    uS.update(u);
    return ResponseEntity.ok("Usuario actualizado correctamente.");
}
}

