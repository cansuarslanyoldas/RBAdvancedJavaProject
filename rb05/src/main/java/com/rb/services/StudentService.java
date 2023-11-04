package com.rb.services;

import com.rb.dto.StudentDTO;
import com.rb.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Optional<Student> findById(Long id);
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);
    void deleteStudent(long id);

    Student findStudent(long id);
}
