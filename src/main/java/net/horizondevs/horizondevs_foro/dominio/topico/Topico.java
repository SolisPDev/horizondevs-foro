package net.horizondevs.horizondevs_foro.dominio.topico;

import jakarta.persistence.*;
import lombok.*;
import net.horizondevs.horizondevs_foro.dominio.curso.Curso;
import net.horizondevs.horizondevs_foro.dominio.usuario.Usuario;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name="topico")
@Table(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @Column(nullable = false)
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

    public Topico(DatosRegistroTopico datosRegistroTopico, String nombre) {
    }
}