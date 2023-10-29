package com.rb.controller;

import com.rb.dto.StudentDTO;
import com.rb.entity.Student;
import com.rb.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
    @PutMapping("/students/update")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentDTO) {
        if(!Objects.isNull(studentService.updateStudent(studentDTO))){
            return ResponseEntity.status(HttpStatus.OK).body(studentDTO.toJsonString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }
    @PostMapping("/students/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO) {
        if(!Objects.isNull(studentService.createStudent(studentDTO))){
            return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO.toJsonString());
        }
        return ResponseEntity.ok("Student is updated successfully.");
    }

    @DeleteMapping("/students/remove/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student is deleted successfully.");
    }

}
