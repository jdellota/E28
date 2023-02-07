package com.example.E28.service;

import com.example.E28.entity.StudentEntity;
import com.example.E28.repository.CourseRepository;
import com.example.E28.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getByID(Long id) {
        return studentRepository.findById(id);
    }
    public void deleteByID(Long id) {
        studentRepository.deleteById(id);
    }

    public Optional<StudentEntity> updateByID(Long id, StudentEntity student) {
        if(studentRepository.findById(id).isPresent()){
            student.setStudentId(Math.toIntExact(id));
            return Optional.of(studentRepository.save(student));
        }
        return studentRepository.findById(id);
    }

    public StudentEntity enroll(Long studentId, Long  courseId) {
        if(courseRepository.findById(courseId).isPresent()&&studentRepository.findById(studentId).isPresent()){
            StudentEntity student=studentRepository.findById(studentId).get();
            student.getCourse().add(courseRepository.findById(courseId).get());
            studentRepository.save(student);
            return student;
        }

        return null;

    }


    public StudentEntity drop(Long studentId, Long courseId) {
        if(courseRepository.findById(courseId).isPresent()&&studentRepository.findById(studentId).isPresent()){
            StudentEntity student=studentRepository.findById(studentId).get();
            student.getCourse().remove(courseRepository.findById(courseId).get());
            studentRepository.save(student);
            return student;
        }
        return null;
    }
}
