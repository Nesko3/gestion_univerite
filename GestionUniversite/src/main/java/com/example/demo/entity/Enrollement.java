package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Enrollement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate enrollementDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Enrollement() {
    }

    public Enrollement(Long id, LocalDate enrollementDate, Status status, Student student, Course course) {
        this.id = id;
        this.enrollementDate = enrollementDate;
        this.status = status;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEnrollementDate() {
        return enrollementDate;
    }

    public void setEnrollementDate(LocalDate enrollementDate) {
        this.enrollementDate = enrollementDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}