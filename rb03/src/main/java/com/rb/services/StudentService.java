package com.rb.services;

import com.rb.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Optional<Student> findById(Long id);
}
