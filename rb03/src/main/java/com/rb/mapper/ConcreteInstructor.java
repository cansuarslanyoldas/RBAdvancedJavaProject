package com.rb.mapper;

import com.rb.entity.Instructor;

public class ConcreteInstructor extends Instructor {
    public ConcreteInstructor() {

    }

    public ConcreteInstructor(String name, String address, String phoneNumber) {
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }
}
