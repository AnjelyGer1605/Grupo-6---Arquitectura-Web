package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Puntos_Usuario {

    @Entity
    @Table(name = "PuntosUsuario")
    public class PuntosUsuario {
        @Id
        private Long id;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idPuntos;

        @Column(nullable = false)
        private int puntosTotal;

        @Column(length = 50, nullable = false)
        private String nivelActual;

        @Column(nullable = false)
        private LocalDateTime fechaInicio;

        @Column(nullable = false)
        private LocalDateTime fechaCaducidad;

        // Relación con Usuario
        @ManyToOne
        @JoinColumn(name = "id_usuario", nullable = false)
        private Usuario usuario;

        public PuntosUsuario() {
        }

        public PuntosUsuario(int idPuntos, int puntosTotal, String nivelActual, LocalDateTime fechaInicio, LocalDateTime fechaCaducidad, Usuario usuario) {
            this.idPuntos = idPuntos;
            this.puntosTotal = puntosTotal;
            this.nivelActual = nivelActual;
            this.fechaInicio = fechaInicio;
            this.fechaCaducidad = fechaCaducidad;
            this.usuario = usuario;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        // Getters y Setters
        public int getIdPuntos() { return idPuntos; }
        public void setIdPuntos(int idPuntos) { this.idPuntos = idPuntos; }

        public int getPuntosTotal() { return puntosTotal; }
        public void setPuntosTotal(int puntosTotal) { this.puntosTotal = puntosTotal; }

        public String getNivelActual() { return nivelActual; }
        public void setNivelActual(String nivelActual) { this.nivelActual = nivelActual; }

        public LocalDateTime getFechaInicio() { return fechaInicio; }
        public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

        public LocalDateTime getFechaCaducidad() { return fechaCaducidad; }
        public void setFechaCaducidad(LocalDateTime fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }

        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    }

}
