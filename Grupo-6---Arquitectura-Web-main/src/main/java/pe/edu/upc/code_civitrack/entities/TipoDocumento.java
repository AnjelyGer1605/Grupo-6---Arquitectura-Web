package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class TipoDocumento {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Table(name = "TipoDocumento")
    public class tipoDocumento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int documentoId;

        @Column(length = 100, nullable = false)
        private String nombre;

        public tipoDocumento() {
        }

        public tipoDocumento(int documentoId, String nombre) {
            this.documentoId = documentoId;
            this.nombre = nombre;
        }

        // Getters y Setters
        public int getDocumentoId() { return documentoId; }
        public void setDocumentoId(int documentoId) { this.documentoId = documentoId; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
    }

}
