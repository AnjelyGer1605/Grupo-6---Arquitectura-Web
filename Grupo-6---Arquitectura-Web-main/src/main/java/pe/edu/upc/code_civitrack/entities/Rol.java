package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(nullable = false, unique = true, length = 50)
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    public Rol(int idRol, String nombreRol, List<Usuario> usuarios) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.usuarios = usuarios;
    }

    public Rol() {

    }

    public int getIdRol() { return idRol; }

    public void setIdRol(int idRol) { this.idRol = idRol; }

    public String getNombreRol() { return nombreRol; }

    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }

    public List<Usuario> getUsuarios() { return usuarios; }

    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
}

