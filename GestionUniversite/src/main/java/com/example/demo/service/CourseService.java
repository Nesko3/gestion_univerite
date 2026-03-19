package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course){

        Optional<Course> existingCourse = courseRepository.findById(id);

        if(existingCourse.isPresent()){
            course.setId(id);
            return courseRepository.save(course);
        }

        return null;
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}