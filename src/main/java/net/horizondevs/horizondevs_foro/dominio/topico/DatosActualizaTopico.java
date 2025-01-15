package net.horizondevs.horizondevs_foro.dominio.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DatosActualizaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                   String fechaCreacion,
                                   Status status) {
}
