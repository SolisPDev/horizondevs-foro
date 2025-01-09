package net.horizondevs.horizondevs_foro.usuario;

import net.horizondevs.horizondevs_foro.perfil.Perfil;

public record DatosRegistroUsuario(
        String nombre,
        String correoElectronico,
        String contrasena,
        Perfil perfil
) {
}
