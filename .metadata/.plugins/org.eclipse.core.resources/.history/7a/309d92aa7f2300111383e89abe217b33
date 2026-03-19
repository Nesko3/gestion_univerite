package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student){

        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isPresent()){
            student.setId(id);
            return studentRepository.save(student);
        }

        return null;
    }

    public void deleteStudent(Long id){

        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent() && student.get().getEnrollements() != null
                && !student.get().getEnrollements().isEmpty()){

            throw new RuntimeException("Impossible de supprimer : étudiant inscrit à des cours");
        }

        studentRepository.deleteById(id);
    }
}