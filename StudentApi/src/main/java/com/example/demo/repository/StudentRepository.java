package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentModel;

public interface StudentRepository extends JpaRepository <StudentModel, Integer>{

}
