package net.horizondevs.horizondevs_foro.controller;

import net.horizondevs.horizondevs_foro.dominio.topico.TopicoRepository;
import net.horizondevs.horizondevs_foro.dominio.usuario.Usuario;
import net.horizondevs.horizondevs_foro.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecursosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    // Buscar el usurio registrado
    public Usuario getAuthenticatedUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        String nombre = userDetails.getUsername();

        Optional<Usuario> usuario = usuarioRepository.findByNombreOrCorreoElectronico(nombre);
        return usuario.orElse(null);
    }
}
