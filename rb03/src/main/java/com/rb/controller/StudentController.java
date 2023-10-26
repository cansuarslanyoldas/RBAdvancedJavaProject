package com.rb.controller;

import com.rb.entity.Student;
import com.rb.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/findStudentById/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable long id) {
        Optional<Student> students = studentService.findById(id);

        if(students.isPresent()){
            return ResponseEntity.ok(students);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
