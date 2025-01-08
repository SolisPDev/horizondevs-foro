package net.horizondevs.horizondevs_foro.usuario;

import jakarta.persistence.*;
import net.horizondevs.horizondevs_foro.perfil.Perfil;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @Column(nullable = false)
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    // Getters y setters
}
