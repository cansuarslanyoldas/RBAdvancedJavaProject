package com.rb.dto;

import com.rb.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String gender;
    private String address;
    private String birthDate;
    private List<Course> courseList;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setInstructorList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student {" + '\'' +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", courseList=" + courseList +
                '}';
    }

    public String toJsonString() {
        return "{"
                + "\"id\":\"" + id + "\","
                + "\"name\":\"" + name + "\","
                + "\"gender\":\"" + gender + "\","
                + "\"address\":\"" + address + "\","
                + "\"birthDate\":\"" + birthDate + "\","
                + "\"courseList\":" + courseList
                + "}";
    }
}
