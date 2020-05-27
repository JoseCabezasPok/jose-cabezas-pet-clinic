package com.example.josecabezaspetclinic.bootstrap;

import com.example.josecabezaspetclinic.model.*;
import com.example.josecabezaspetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();
        if(count==0){
        loadData();}


    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);
        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);
        PetType dog = new PetType();

        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();

        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes..");


        Owner owner1 = new Owner();

        owner1.setFirstName("Jose");
        owner1.setLastName("Cabezas");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12341234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Brno");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);
        Owner owner2 = new Owner();

        owner2.setFirstName("Nati");
        owner2.setLastName("Moares");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("12341234");
        Pet fionaCat = new Pet();
        fionaCat.setPetType(savedCatPetType);
        fionaCat.setName("Kat");
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setOwner(owner2);
        owner2.getPets().add(fionaCat);
        ownerService.save(owner2);

        Visit visit = new Visit();
        visit.setPet(fionaCat);
        visit.setDate(LocalDate.now());
        visit.setDescription("CatotiCatoti");
        visitService.save(visit);

        System.out.println("Loaded owners..");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Kim");
        vet2.setLastName("Power");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets..");
    }
}
