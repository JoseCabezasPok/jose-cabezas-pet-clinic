package com.example.josecabezaspetclinic.repositories;

import com.example.josecabezaspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
