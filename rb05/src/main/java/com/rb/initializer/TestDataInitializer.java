package com.rb.initializer;

import com.rb.entity.*;
import com.rb.repository.CourseRepository;
import com.rb.repository.InstructorRepository;
import com.rb.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestDataInitializer implements ApplicationRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    @Autowired
    public TestDataInitializer(StudentRepository studentRepository,
                               CourseRepository courseRepository,
                               InstructorRepository instructorRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Student student1 = new Student();
        student1.setName("Cansu");
        student1.setGender("K");
        student1.setAddress("Çorlu");
        student1.setBirthDate("11.06.1993");

        Student student2 = new Student();
        student2.setName("Metin");
        student2.setGender("E");
        student2.setAddress("Çorlu");
        student2.setBirthDate("01.04.1993");

        Instructor instructor1 = new VisitorResourcer("Koray","XX Mah.","5433777884",20.0);
        Instructor instructor2 = new PermanentResourcer("Güney","YY Mah.","5433775554",50.0);

        Course course1 = new Course("JAVA","1",20,LocalDateTime.now(),LocalDateTime.now());
        Course course2 = new Course("SPRING","2",50,LocalDateTime.now(),LocalDateTime.now());

        instructor1.getCourseList().add(course1);
        instructor2.getCourseList().add(course2);


        studentRepository.save(student1);
        studentRepository.save(student2);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);

        courseRepository.save(course1);
        courseRepository.save(course2);


        System.out.println("Start....");
    }
}
