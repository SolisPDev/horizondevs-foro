package net.horizondevs.horizondevs_foro.perfil;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Getters y setters
}