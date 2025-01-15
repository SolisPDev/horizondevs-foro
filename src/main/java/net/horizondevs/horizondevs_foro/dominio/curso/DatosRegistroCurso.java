package net.horizondevs.horizondevs_foro.dominio.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank
        String nombre,
        @NotBlank
        @NotNull
        String categoria
) {
}
