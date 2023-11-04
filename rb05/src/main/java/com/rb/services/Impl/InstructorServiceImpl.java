package com.rb.services.Impl;

import com.rb.dto.InstructorDTO;
import com.rb.entity.Instructor;
import com.rb.mapper.InstructorMapper;
import com.rb.repository.InstructorRepository;
import com.rb.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private InstructorMapper instructorMapper;
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> findById(Long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public InstructorDTO createInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapDTOToInstructor(instructorDTO);
        return instructorMapper.mapInstructorToDTO(instructorRepository.save(instructor));
    }

    @Override
    public InstructorDTO updateInstructor(InstructorDTO courseDTO) {
        return null;
    }

    @Override
    public void deleteInstructor(long id) {

    }

    @Override
    public Instructor findInstructor(long id) {
        return null;
    }
}
