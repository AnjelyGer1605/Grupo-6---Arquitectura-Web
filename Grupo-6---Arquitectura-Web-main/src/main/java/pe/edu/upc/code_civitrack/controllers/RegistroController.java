package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.RegistroDTO;
import pe.edu.upc.code_civitrack.entities.Registro;
import pe.edu.upc.code_civitrack.servicesInterfaces.IRegistroService;

import java.util.List;
import java.util.stream.Collectors;


    @RestController
    @RequestMapping("/registros")
    public class RegistroController {
        @Autowired
        private IRegistroService regS;

        @GetMapping
        public List<RegistroDTO> listar() {
            return regS.list().stream().map(x -> {
                ModelMapper m = new ModelMapper();
                return m.map(x, RegistroDTO.class);
            }).collect(Collectors.toList());
        }

        @PostMapping
        public void insertar(@RequestBody RegistroDTO dto) {
            ModelMapper m = new ModelMapper();
            Registro r = m.map(dto, Registro.class);
            regS.insert(r);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
            Registro reg = regS.listId(id);
            if (reg == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un registro con el ID: " + id);
            }
            regS.delete(id);
            return ResponseEntity.ok("Registro eliminado correctamente.");
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
            Registro reg = regS.listId(id);
            if (reg == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un registro con el ID: " + id);
            }
            ModelMapper m = new ModelMapper();
            RegistroDTO dto = m.map(reg, RegistroDTO.class);
            return ResponseEntity.ok(dto);
        }

        @PutMapping
        public ResponseEntity<String> modificar(@RequestBody RegistroDTO dto) {
            ModelMapper m = new ModelMapper();
            Registro r = m.map(dto, Registro.class);

            Registro existente = regS.listId(r.getIdRegistro());
            if (existente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un registro con el ID: " + r.getIdRegistro());
            }
            regS.update(r);
            return ResponseEntity.ok("Registro actualizado correctamente.");
        }
    }
