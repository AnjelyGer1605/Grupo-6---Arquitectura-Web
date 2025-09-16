package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.RolDTO;
import pe.edu.upc.code_civitrack.entities.Rol;
import pe.edu.upc.code_civitrack.servicesInterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;


    @RestController
    @RequestMapping("/roles")
    public class RolController {
        @Autowired
        private IRolService rS;

        @GetMapping
        public List<RolDTO> listar() {
            return rS.list().stream().map(x -> {
                ModelMapper m = new ModelMapper();
                return m.map(x, RolDTO.class);
            }).collect(Collectors.toList());
        }

        @PostMapping
        public void insertar(@RequestBody RolDTO dto) {
            ModelMapper m = new ModelMapper();
            Rol r = m.map(dto, Rol.class);
            rS.insert(r);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
            Rol rol = rS.listId(id);
            if (rol == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un rol con el ID: " + id);
            }
            rS.delete(id);
            return ResponseEntity.ok("Rol eliminado correctamente.");
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
            Rol rol = rS.listId(id);
            if (rol == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un rol con el ID: " + id);
            }
            ModelMapper m = new ModelMapper();
            RolDTO dto = m.map(rol, RolDTO.class);
            return ResponseEntity.ok(dto);
        }

        @PutMapping
        public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
            ModelMapper m = new ModelMapper();
            Rol r = m.map(dto, Rol.class);

            Rol existente = rS.listId(r.getIdRol());
            if (existente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un rol con el ID: " + r.getIdRol());
            }
            rS.update(r);
            return ResponseEntity.ok("Rol actualizado correctamente.");
        }
    }

