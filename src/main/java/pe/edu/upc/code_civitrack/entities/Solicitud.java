package pe.edu.upc.civitrack.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Solicitud {

    @Entity
    @Table(name = "Solicitud")
    public
    class solicitud {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idSolicitud;

        @Column(length = 50, nullable = false)
        private String nombre;

        @Column(length = 50, nullable = false)
        private String apellidos;

        @Column(length = 100, nullable = false)
        private String correo;

        @Column(length = 9, nullable = false)
        private String telefono;

        @Column(length = 250)
        private String mensaje;

        @Column(nullable = false)
        private LocalDateTime fechaEnvio;

        // Relaciones
        @ManyToOne
        @JoinColumn(name = "documento_id", nullable = false)
        private TipoDocumento tipoDocumento;

        @ManyToOne
        @JoinColumn(name = "id_usuario", nullable = false)
        private Usuario usuario;

        public solicitud() {
        }

        public solicitud(int idSolicitud, String nombre, String apellidos, String correo, String telefono, String mensaje, LocalDateTime fechaEnvio, TipoDocumento tipoDocumento, Usuario usuario) {
            this.idSolicitud = idSolicitud;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.correo = correo;
            this.telefono = telefono;
            this.mensaje = mensaje;
            this.fechaEnvio = fechaEnvio;
            this.tipoDocumento = tipoDocumento;
            this.usuario = usuario;
        }

        // Getters y Setters
        public int getIdSolicitud() { return idSolicitud; }
        public void setIdSolicitud(int idSolicitud) { this.idSolicitud = idSolicitud; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getApellidos() { return apellidos; }
        public void setApellidos(String apellidos) { this.apellidos = apellidos; }

        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        public String getMensaje() { return mensaje; }
        public void setMensaje(String mensaje) { this.mensaje = mensaje; }

        public LocalDateTime getFechaEnvio() { return fechaEnvio; }
        public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

        public TipoDocumento getTipoDocumento() { return tipoDocumento; }
        public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }

        public Usuario getUsuario() { return usuario; }
        public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    }

}
