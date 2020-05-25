package com.example.josecabezaspetclinic.services;


import com.example.josecabezaspetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
