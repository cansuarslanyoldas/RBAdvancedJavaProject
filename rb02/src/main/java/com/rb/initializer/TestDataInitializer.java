package com.rb.initializer;

import com.rb.entity.Course;
import com.rb.entity.PermanentResourcer;
import com.rb.entity.Student;
import com.rb.entity.VisitorResourcer;
import com.rb.repository.CourseRepository;
import com.rb.repository.InstructorRepository;
import com.rb.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        Student student = new Student();
        student.setName("Cansu");
        student.setGender("K");
        student.setAddress("Çorlu");
        student.setBirthDate("11.06.1993");

        Course course1 = new Course();
        course1.setCourseName("Java");
        course1.setCreditPoints(50);
        course1.setCourseCode("1");

        Course course2 = new Course();
        course2.setCourseName("Hibernate");
        course2.setCreditPoints(20);


        course2.setCourseCode("2");

        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        student.setCourseList(courseList);

        VisitorResourcer visitorResourcer = new VisitorResourcer();
        visitorResourcer.setName("Koray");
        visitorResourcer.setHourlySalary(20.0);


        PermanentResourcer permanentResourcer = new PermanentResourcer();
        permanentResourcer.setName("Güney");
        permanentResourcer.setFixedSalary(5000.0);



        course1.setInstructor(permanentResourcer);
        course2.setInstructor(visitorResourcer);

        studentRepository.save(student);
        courseRepository.save(course1);
        courseRepository.save(course2);
        instructorRepository.save(visitorResourcer);
        instructorRepository.save(permanentResourcer);

        System.out.println("Start....");
    }
}
