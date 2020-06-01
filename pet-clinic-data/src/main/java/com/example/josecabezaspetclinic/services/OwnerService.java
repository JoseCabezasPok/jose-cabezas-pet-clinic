package com.example.josecabezaspetclinic.services;

import com.example.josecabezaspetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
