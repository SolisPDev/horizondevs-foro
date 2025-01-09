package net.horizondevs.horizondevs_foro.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Page<Curso> findAll(Pageable paginacion);
}
