package com.example.E28.controller;

import com.example.E28.entity.CourseEntity;
import com.example.E28.entity.StudentEntity;
import com.example.E28.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping(path="/add")
    public CourseEntity addCourse (@RequestBody CourseEntity course){
        return courseService.addCourse(course);

    }
    @GetMapping(path="/get/all")
    public List<CourseEntity> getAllCourses() {

        return courseService.getAllCourses();
    }
    @GetMapping(path="/get/{id}")
    public Optional<CourseEntity> getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }
    @PutMapping(path="/update/{id}")
    public Optional<CourseEntity> updateCourse(@PathVariable Long id, @RequestBody CourseEntity course){
        return courseService.updateCourseById(id, course);
    }

}
