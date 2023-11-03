package com.rb.controller;

import com.rb.dto.InstructorDTO;
import com.rb.entity.Instructor;
import com.rb.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class InstructorController {

    private final InstructorService instructorService ;
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/getAllInstructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/findInstructorById/{id}")
    public ResponseEntity<Optional<Instructor>> findInstructorById(@PathVariable long id) {
        Optional<Instructor> instructors = instructorService.findById(id);

        if(instructors.isPresent()){
            return ResponseEntity.ok(instructors);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/instructor/update")
    public ResponseEntity<String> updateInstructor(@RequestBody InstructorDTO instructorDTO) {
        if(!Objects.isNull(instructorService.updateInstructor(instructorDTO))){
            return ResponseEntity.status(HttpStatus.OK).body(instructorDTO.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
    }
    @PostMapping("/instructor/create")
    public ResponseEntity<String> createInstructor(@RequestBody InstructorDTO instructorDTO) {
        if(!Objects.isNull(instructorService.createInstructor(instructorDTO))){
            return ResponseEntity.status(HttpStatus.CREATED).body(instructorDTO.toString());
        }
        return ResponseEntity.ok("Instructor is updated successfully.");
    }

    @DeleteMapping("/instructor/remove/{id}")
    public ResponseEntity<String> removeInstructor(@PathVariable("id") long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.ok("Instructor is deleted successfully.");
    }

}
