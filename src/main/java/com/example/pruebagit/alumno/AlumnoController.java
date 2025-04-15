package com.example.pruebagit.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok(alumnoRepository.findById(id).get());
    }

    @PostMapping
    ResponseEntity<Alumno> setAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoRepository.save(alumno));
    }
}
