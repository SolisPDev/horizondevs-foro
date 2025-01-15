package net.horizondevs.horizondevs_foro.dominio.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTitulo(String titulo);

    Page<Topico> findAll(Pageable pageable);
}
