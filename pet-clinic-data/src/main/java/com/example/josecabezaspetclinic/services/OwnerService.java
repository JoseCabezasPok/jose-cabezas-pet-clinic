package com.example.josecabezaspetclinic.services;

import com.example.josecabezaspetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);


}
