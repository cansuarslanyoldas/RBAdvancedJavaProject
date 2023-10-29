package com.rb.entity;


import jakarta.persistence.*;

@Entity
public class PermanentResourcer extends Instructor {

    private double fixedSalary;

    public PermanentResourcer(){

    }
    public PermanentResourcer(double fixedSalary){
        this.fixedSalary=fixedSalary;
    }

    public PermanentResourcer(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
