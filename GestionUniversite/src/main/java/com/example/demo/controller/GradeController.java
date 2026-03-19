package com.example.demo.controller;

import com.example.demo.entity.Grade;
import com.example.demo.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public Optional<Grade> getGradeById(@PathVariable Long id){
        return gradeService.getGradeById(id);
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade){
        return gradeService.createGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id,@RequestBody Grade grade){
        return gradeService.updateGrade(id,grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id){
        gradeService.deleteGrade(id);
    }
}