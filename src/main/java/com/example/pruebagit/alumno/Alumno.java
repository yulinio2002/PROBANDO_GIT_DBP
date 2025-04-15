package com.example.pruebagit.alumno;

import com.example.pruebagit.grade.Grade;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String code;

    //@ManyToMany(mappedBy = "alumno")
    //private List<Grade> grades;

}
