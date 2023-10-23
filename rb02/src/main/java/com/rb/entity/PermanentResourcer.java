package com.rb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permanent_resourcers")
public class PermanentResourcer extends Instructor {

    private double fixedSalary;

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
