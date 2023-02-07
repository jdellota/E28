package com.example.E28.service;

import com.example.E28.entity.CourseEntity;
import com.example.E28.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public CourseEntity addCourse(CourseEntity course) {
        return courseRepository.save(course);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }
    public Optional<CourseEntity> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public Optional<CourseEntity> updateCourseById(Long id, CourseEntity course) {
        if(courseRepository.findById(id).isPresent()){
            course.setCourseId(Math.toIntExact(id));
            return Optional.of(courseRepository.save(course));
        }
        return courseRepository.findById(id);
    }


}
