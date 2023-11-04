package com.rb.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "visitor_resourcers")
public class VisitorResourcer extends Instructor {

    private double hourlySalary;

    public VisitorResourcer(){

    }
    public VisitorResourcer(double hourlySalary){
        this.hourlySalary=hourlySalary;
    }

    public VisitorResourcer(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
