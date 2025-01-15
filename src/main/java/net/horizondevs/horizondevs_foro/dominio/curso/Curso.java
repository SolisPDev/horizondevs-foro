package net.horizondevs.horizondevs_foro.dominio.curso;

import lombok.*;
import jakarta.persistence.*;
import net.horizondevs.horizondevs_foro.dominio.topico.Topico;

import java.util.Set;

@Entity(name = "Curso")
@Table(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Topico> topico;

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }
}
