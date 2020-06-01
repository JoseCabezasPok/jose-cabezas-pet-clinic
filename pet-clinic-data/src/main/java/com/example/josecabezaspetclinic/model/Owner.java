package com.example.josecabezaspetclinic.model;



import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String adress, String city,
                 String telephone, Set<Pet> pets) {
        super(id,firstName,lastName);
        this.address = adress;
        this.city = city;
        this.telephone = telephone;
        if(pets != null){
        this.pets = pets;}
    }

    @Column(name = "telephone")
    private String telephone;
    @Column(name ="city")
    private String city;
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String name){
        return getPet(name,false);
    }
    public Pet getPet(String name, boolean ignoreNew){
        name = name.toLowerCase();
        for(Pet pet : this.pets){
            if(!ignoreNew || !pet.isNew()){
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name)){
                    return pet;
                }
            }

        }
         return null;
    }



}
