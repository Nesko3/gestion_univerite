package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentModel;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
		
	}
	
	public List<StudentModel> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Optional<StudentModel> getStudentById(int id){
		return studentRepository.findById(id);
	}
	
	public StudentModel saveStudent(StudentModel student) {
		return studentRepository.save(student);
	}
	
	public StudentModel updateStudent(int id, StudentModel student) {
		student.setId(id);
		return studentRepository.save(student);
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
