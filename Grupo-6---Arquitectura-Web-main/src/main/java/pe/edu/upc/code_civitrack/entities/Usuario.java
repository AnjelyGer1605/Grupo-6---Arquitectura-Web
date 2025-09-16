package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 255)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    @Column(nullable = false, length = 100)
    private String universidad;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;


    public Usuario(int idUsuario, String nombre, int telefono, String correo, String contraseña, Rol rol, String universidad, LocalDate fechaIngreso, LocalDateTime fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.universidad = universidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario() {

    }


    public int getIdUsuario() { return idUsuario; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getTelefono() { return telefono; }

    public void setTelefono(int telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }

    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) { this.universidad = universidad; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}


