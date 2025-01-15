package net.horizondevs.horizondevs_foro.dominio.respuesta;

import jakarta.persistence.*;
import net.horizondevs.horizondevs_foro.dominio.topico.Topico;
import net.horizondevs.horizondevs_foro.dominio.usuario.Usuario;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fechaCreacion;

    @Column
    private boolean solucion;

    // Getters y setters
}