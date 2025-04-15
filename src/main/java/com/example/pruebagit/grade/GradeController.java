package com.example.pruebagit.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping
    ResponseEntity<List<Grade>> getGrades(){
        return ResponseEntity.ok(gradeRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Grade> getGrade(@PathVariable Long id){
        return ResponseEntity.ok(gradeRepository.findById(id).get());
    }

    @PostMapping
    ResponseEntity<Grade> setGrade(@RequestBody Grade grade){
        return ResponseEntity.ok(gradeRepository.save(grade));
    }


}
