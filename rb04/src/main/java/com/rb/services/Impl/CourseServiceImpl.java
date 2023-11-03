package com.rb.services.Impl;

import com.rb.dto.CourseDTO;
import com.rb.entity.Course;
import com.rb.exception.CourseNotFoundException;
import com.rb.mapper.CourseMapper;
import com.rb.repository.CourseRepository;
import com.rb.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private CourseMapper courseMapper;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course= courseMapper.mapDTOToCourse(courseDTO);
        return courseMapper.mapCourseToDTO(courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        long id = courseDTO.getId();
        Course existingCourse = findCourse(id);

        if (existingCourse != null) {
            Course updatedCourse = courseMapper.mapDTOToCourse(courseDTO);
            updatedCourse.setId(id);
            updatedCourse = courseRepository.save(updatedCourse);

            return courseMapper.mapCourseToDTO(updatedCourse);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCourse(long id) {
      Course course = findCourse(id);
      courseRepository.delete(course);
    }

    @Override
    public Course findCourse(long id) {
        System.out.println("Inside CourseServiceImpl");
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID : " + id));

    }
}
