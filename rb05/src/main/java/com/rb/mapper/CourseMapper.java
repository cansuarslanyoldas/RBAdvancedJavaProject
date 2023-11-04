package com.rb.mapper;

import com.rb.dto.CourseDTO;
import com.rb.entity.Course;

public class CourseMapper {

    public Course mapDTOToCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCreditPoints(courseDTO.getCreditPoints());
        course.setCdate(courseDTO.getCdate());
        course.setUdate(courseDTO.getUdate());
        return course;
    }

    public CourseDTO mapCourseToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCreditPoints(course.getCreditPoints());
        courseDTO.setCdate(course.getCdate());
        courseDTO.setUdate(course.getUdate());
        return courseDTO;
    }
}
