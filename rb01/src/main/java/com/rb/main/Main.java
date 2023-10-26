package com.rb.main;


import com.rb.entity.Course;
import com.rb.entity.PermanentResourcer;
import com.rb.entity.Student;
import com.rb.entity.VisitorResourcer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();



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
        course1.setStudent(student);
        course2.setStudent(student);




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

        entityManager.persist(visitorResourcer);
        entityManager.persist(permanentResourcer);
        entityManager.persist(student);
        entityManager.persist(course1);
        entityManager.persist(course2);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
