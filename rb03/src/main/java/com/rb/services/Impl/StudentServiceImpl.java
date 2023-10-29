package com.rb.services.Impl;

import com.rb.dto.StudentDTO;
import com.rb.entity.Student;
import com.rb.exception.StudentNotFoundException;
import com.rb.mapper.StudentMapper;
import com.rb.repository.StudentRepository;
import com.rb.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private  StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.mapDTOToStudent(studentDTO);
        return studentMapper.mapStudentToDTO(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(long id) {
        Student student = findStudent(id);
        studentRepository.delete(student);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        long id = studentDTO.getId();
        Student existingStudent = findStudent(id);

        if (existingStudent != null) {
            Student updatedStudent = studentMapper.mapDTOToStudent(studentDTO);
            updatedStudent.setId(id);
            updatedStudent = studentRepository.save(updatedStudent);

            return studentMapper.mapStudentToDTO(updatedStudent);
        } else {
            return null;
        }
    }

    @Override
    public Student findStudent(long id) {
        System.out.println("Inside StudentServiceImpl");
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID : " + id));
    }


}
