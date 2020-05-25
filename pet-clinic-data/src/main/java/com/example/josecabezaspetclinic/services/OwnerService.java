package com.example.josecabezaspetclinic.services;

import com.example.josecabezaspetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastname);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
