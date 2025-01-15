package net.horizondevs.horizondevs_foro.dominio.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombreOrCorreoElectronico(String nombre);
}
