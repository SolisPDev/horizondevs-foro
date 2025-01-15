package net.horizondevs.horizondevs_foro.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import net.horizondevs.horizondevs_foro.dominio.curso.CursoRepository;
import net.horizondevs.horizondevs_foro.dominio.curso.DatosRegistroCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")

public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Solo los administradores pueden acceder a este endpoint.
    public ResponseEntity<DatosRespuestaCurso> registerCourse
            (@RequestBody @Validated DatosRegistroCurso datosRegistroCurso,
             UriComponentsBuilder uriComponentsBuilder) {
        // Verificar si el curso ya existe en la base de datos, buscando
        // por nombre:
        Optional<Curso> existingCourse = cursoRepository.findByName(DatosRegistroCurso.nombre());
        if (existingCourse.isPresent()) {
            throw new ValidationException("Ya existe ese curso en la base de datos.");
        }
        // Crear el curso a partir de los datos recibidos:
        Curso curso = new Curso(DatosRegistroCurso);
        // Guardar el curso en la base de datos:
        cursoRepository.save(curso);
        // Construir URL del nuevo recurso:
        URI url = uriComponentsBuilder.path("/courses/{courseId}")
                .buildAndExpand(course.getCourseId()).toUri();
        // Devolver la respuesta con los detalles del curso creado:
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataResponseCourse(course));
    }
}







