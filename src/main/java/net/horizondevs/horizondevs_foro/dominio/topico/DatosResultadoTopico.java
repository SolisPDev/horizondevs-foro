package net.horizondevs.horizondevs_foro.dominio.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DatosResultadoTopico(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        String fechaDeCreacion,
        Status status
) {
    public DatosResultadoTopico(Topico topico) {
        this
                (
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion().toString(),
                        topico.getStatus()
                )
    }
}
