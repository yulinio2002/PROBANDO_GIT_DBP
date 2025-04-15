package com.example.pruebagit.alumno;

import com.example.pruebagit.exceptions.ResourceConflictException;
import com.example.pruebagit.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    ResponseEntity<List<Alumno>> getAlumnos(){
        return ResponseEntity.ok(alumnoRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id){
        //return ResponseEntity.ok(alumnoRepository.findById(id).get());
        Optional<Alumno> foundArtista = alumnoRepository.findById(id);
        if (foundArtista.isPresent()) {

            return ResponseEntity.ok(alumnoRepository.findById(id).get());
        }
        throw new ResourceNotFoundException("El alumno " + id + " no fue encontrado");

    }

    @PostMapping
    ResponseEntity<Alumno> setAlumno(@RequestBody Alumno alumno){
        //return ResponseEntity.ok(alumnoRepository.save(alumno));
        Optional<Alumno> foundArtistaByUsername = alumnoRepository.findByLastName(alumno.getLastName());

        if (foundArtistaByUsername.isEmpty()) {
            return ResponseEntity.ok(alumnoRepository.save(alumno));
        }
        throw new ResourceConflictException("El artista con username " + alumno.getLastName() + " ya existe");

    }

}
