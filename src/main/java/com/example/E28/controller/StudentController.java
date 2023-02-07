package com.example.E28.controller;

import com.example.E28.entity.StudentEntity;
import com.example.E28.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(path="/add")
    public StudentEntity addStudent (@RequestBody StudentEntity student){
        return studentService.addStudent(student);

    }
    @GetMapping(path="/get/all")
    public List<StudentEntity> getAllStudents() {

        return studentService.getAllStudents();
    }
    @GetMapping(path="/get/{id}")
    public Optional<StudentEntity> getById(@PathVariable Long id) {
        return studentService.getByID(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteById(@PathVariable Long id) {
       studentService.deleteByID(id);
    }

    @PutMapping(path="/update/{id}")
    public Optional<StudentEntity> updateById(@PathVariable Long id, @RequestBody StudentEntity student) {
        return studentService.updateByID(id, student);
    }
    @PutMapping(path="/enroll/{studentId}/{courseId}")
    public StudentEntity enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.enroll(studentId, courseId);
    }
    @DeleteMapping(path="/drop/{studentId}/{courseId}")
    public StudentEntity drop(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.drop(studentId, courseId);
  }
}
