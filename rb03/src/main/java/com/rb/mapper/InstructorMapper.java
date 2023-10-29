package com.rb.mapper;

import com.rb.dto.InstructorDTO;
import com.rb.entity.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {

    public Instructor mapDTOToInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = new ConcreteInstructor();
        instructor.setId(instructorDTO.getId());
        instructor.setName(instructorDTO.getName());
        instructor.setAddress(instructorDTO.getAddress());
        instructor.setPhoneNumber(instructorDTO.getPhoneNumber());
        return instructor;
    }

    public InstructorDTO mapInstructorToDTO(Instructor instructor) {
        InstructorDTO dto = new InstructorDTO();
        dto.setId(instructor.getId());
        dto.setName(instructor.getName());
        dto.setAddress(instructor.getAddress());
        dto.setPhoneNumber(instructor.getPhoneNumber());
        return dto;
    }
}
