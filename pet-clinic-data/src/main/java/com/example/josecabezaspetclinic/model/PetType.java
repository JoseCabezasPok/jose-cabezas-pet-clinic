package com.example.josecabezaspetclinic.model;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String Name;

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.Name = name;
    }

    @Override
    public String toString(){return this.Name;}


}
