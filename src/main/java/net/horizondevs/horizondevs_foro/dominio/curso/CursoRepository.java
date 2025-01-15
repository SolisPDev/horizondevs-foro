package net.horizondevs.horizondevs_foro.dominio.curso;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Optional<Curso> findByName(String nombre);
}
