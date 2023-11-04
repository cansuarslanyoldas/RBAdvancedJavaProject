package com.rb.mapper;

import com.rb.dto.StudentDTO;
import com.rb.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student mapDTOToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setGender(studentDTO.getGender());
        student.setAddress(studentDTO.getAddress());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setCourses(studentDTO.getCourseList());
        return student;
    }

    public StudentDTO mapStudentToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setName(student.getName());
        dto.setAddress(student.getAddress());
        dto.setBirthDate(student.getBirthDate());
        dto.setGender(student.getGender());
        dto.setCourseList(student.getCourses());
        return dto;
    }

}
