package com.example.josecabezaspetclinic.model;

import org.springframework.context.annotation.Configuration;


public class PetType extends BaseEntity{

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
