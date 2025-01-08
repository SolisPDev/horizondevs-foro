package net.horizondevs.horizondevs_foro.curso;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String categoria;

    // Getters y setters
}