package net.horizondevs.horizondevs_foro.dominio.usuario;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.horizondevs.horizondevs_foro.dominio.perfil.Perfil;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @Setter
    private String contrasena;

    @Column
    private String perfil;


}
