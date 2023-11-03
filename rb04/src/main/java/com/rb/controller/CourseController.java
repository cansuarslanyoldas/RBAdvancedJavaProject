package com.rb.controller;

import com.rb.dto.CourseDTO;
import com.rb.entity.Course;
import com.rb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/findCourseById/{id}")
    public ResponseEntity<Optional<Course>> findCourseById(@PathVariable long id) {
        Optional<Course> courses = courseService.findById(id);

        if(courses.isPresent()){
            return ResponseEntity.ok(courses);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/course/update")
    public ResponseEntity<String> updateCourse(@RequestBody CourseDTO courseDTO) {
        if(!Objects.isNull(courseService.updateCourse(courseDTO))){
            return ResponseEntity.status(HttpStatus.OK).body(courseDTO.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }
    @PostMapping("/course/create")
    public ResponseEntity<String> createCourse(@RequestBody CourseDTO courseDTO) {
        if(!Objects.isNull(courseService.createCourse(courseDTO))){
            return ResponseEntity.status(HttpStatus.CREATED).body(courseDTO.toString());
        }
        return ResponseEntity.ok("Course is updated successfully.");
    }

    @DeleteMapping("/course/remove/{id}")
    public ResponseEntity<String> removeCourse(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course is deleted successfully.");
    }
}
