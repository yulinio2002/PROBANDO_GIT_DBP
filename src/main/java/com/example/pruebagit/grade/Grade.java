package com.example.pruebagit.grade;

import com.example.pruebagit.alumno.Alumno;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long score;
    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Alumno_Grade",
            joinColumns = @JoinColumn(name = "Alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "Grade_id"))
    private List<Alumno> alumnos = new ArrayList<>();
    */
}
