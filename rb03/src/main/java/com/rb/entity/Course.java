package com.rb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import java.util.List;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String courseName;
    private String courseCode;
    private int creditPoints;
    private LocalDateTime cdate;
    private LocalDateTime udate;

    @ManyToOne
    private Instructor instructor;

    @ManyToMany
    private List<Student> students;
    public Course() {

    }
    public Course(String courseName){
        this.courseName = courseName;
    }

    public Course(String courseName,String courseCode, int creditPoints, LocalDateTime cdate, LocalDateTime udate){
        this.courseName=courseName;
        this.courseCode=courseCode;
        this.creditPoints= creditPoints;
        this.cdate=cdate;
        this.udate=udate;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public void setCdate(LocalDateTime cdate) {
        this.cdate = cdate;
    }

    public LocalDateTime getUdate() {
        return udate;
    }

    public void setUdate(LocalDateTime udate) {
        this.udate = udate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
