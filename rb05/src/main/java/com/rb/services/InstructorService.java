package com.rb.services;

import com.rb.dto.InstructorDTO;
import com.rb.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {

    List<Instructor> getAllInstructors();
    Optional<Instructor> findById(Long id);

    InstructorDTO createInstructor(InstructorDTO instructorDTO);
    InstructorDTO updateInstructor(InstructorDTO instructorDTO);
    void deleteInstructor(long id);

    Instructor findInstructor(long id);
}
