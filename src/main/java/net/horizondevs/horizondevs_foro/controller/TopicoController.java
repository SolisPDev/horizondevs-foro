package net.horizondevs.horizondevs_foro.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import net.horizondevs.horizondevs_foro.dominio.topico.DatosRegistroTopico;
import net.horizondevs.horizondevs_foro.dominio.topico.DatosResultadoTopico;
import net.horizondevs.horizondevs_foro.dominio.topico.Topico;
import net.horizondevs.horizondevs_foro.dominio.topico.TopicoRepository;
import net.horizondevs.horizondevs_foro.dominio.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private RecursosService recursosService;
    @Autowired
    private TopicoRepository topicoRepository;

    // ****  Registrando un tópico  ****
    @PostMapping
    public ResponseEntity<DatosResultadoTopico> agregandoTopico(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder) {

        // buscar el topico por titulo
        Optional<Topico> topicoEncontrado = topicoRepository.findByTitulo(datosRegistroTopico.titulo());

        if (topicoEncontrado.isPresent()) {
            throw new ValidationException("Previamente se registro un topico con ese Titulo");
        }

        // Verificar usuario autenticado
        Usuario usuario = recursosService.getAuthenticatedUser();


        Topico topico = new Topico(datosRegistroTopico, usuario.getNombre());
        topico.setAutor(usuario);


        topico = topicoRepository.save(topico);

        // Url de respuesta
        URI url = uriComponentsBuilder.path("/topics/{topicId}")
                .buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(new DatosResultadoTopico(topico));
    }
}
