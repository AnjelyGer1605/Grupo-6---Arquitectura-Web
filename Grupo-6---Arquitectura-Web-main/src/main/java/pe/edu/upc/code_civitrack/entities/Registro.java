package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegistro;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)  // FK con Usuario
    private Usuario usuario;

    @Column(name = "accion", nullable = false, length = 100)
    private String accion;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "detalle", length = 255)
    private String detalle;


    public Registro() {
    }

    public Registro(int idRegistro, Usuario usuario, String accion, LocalDateTime fechaRegistro, String detalle) {
        this.idRegistro = idRegistro;
        this.usuario = usuario;
        this.accion = accion;
        this.fechaRegistro = fechaRegistro;
        this.detalle = detalle;
    }

    // Getters y Setters
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}


