package com.rb.services;

import com.rb.dto.CourseDTO;
import com.rb.dto.StudentDTO;
import com.rb.entity.Course;
import com.rb.entity.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();
    Optional<Course> findById(Long id);
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(CourseDTO courseDTO);
    void deleteCourse(long id);

    Course findCourse(long id);
}
