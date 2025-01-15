package net.horizondevs.horizondevs_foro.dominio.usuario;

import net.horizondevs.horizondevs_foro.dominio.perfil.Perfil;

public record DatosRegistroUsuario(
        String nombre,
        String correoElectronico,
        String contrasena,
        Perfil perfil
) {
}
