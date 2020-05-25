package com.example.josecabezaspetclinic.services;

import com.example.josecabezaspetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
