package net.horizondevs.horizondevs_foro.topico;

import jakarta.persistence.*;
import net.horizondevs.horizondevs_foro.curso.Curso;
import net.horizondevs.horizondevs_foro.usuario.Usuario;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    // Getters y setters
}