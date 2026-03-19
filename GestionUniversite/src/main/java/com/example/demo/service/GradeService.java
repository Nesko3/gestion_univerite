package com.example.demo.service;

import com.example.demo.entity.Grade;
import com.example.demo.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id){
        return gradeRepository.findById(id);
    }

    public Grade createGrade(Grade grade){
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade grade){

        Optional<Grade> existingGrade = gradeRepository.findById(id);

        if(existingGrade.isPresent()){
            grade.setId(id);
            return gradeRepository.save(grade);
        }

        return null;
    }

    public void deleteGrade(Long id){
        gradeRepository.deleteById(id);
    }
}