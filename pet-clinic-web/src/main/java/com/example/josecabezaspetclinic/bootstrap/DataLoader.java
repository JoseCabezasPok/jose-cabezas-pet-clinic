package com.example.josecabezaspetclinic.bootstrap;

import com.example.josecabezaspetclinic.model.Owner;
import com.example.josecabezaspetclinic.model.Vet;
import com.example.josecabezaspetclinic.services.OwnerService;
import com.example.josecabezaspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {

        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);
        System.out.println("Loaded owners..");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Kim");
        vet2.setLastName("Power");
        vetService.save(vet2);

        System.out.println("Loaded Vets..");


    }
}
