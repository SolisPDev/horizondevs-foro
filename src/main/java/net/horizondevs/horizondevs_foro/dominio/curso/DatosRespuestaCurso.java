package net.horizondevs.horizondevs_foro.dominio.curso;

public record DatosRespuestaCurso(
        Integer id,
        String nombre,
        String categoria
) {
    public DatosRespuestaCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
