package com.rb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "visitor_resourcers")
public class VisitorResourcer extends Instructor {

    private double hourlySalary;

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
