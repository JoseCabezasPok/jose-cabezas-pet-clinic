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
        radiology.setDescription("radiologia");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentista");
        Specialty savedDentistry = specialtyService.save(dentistry);
        Specialty surgery = new Specialty();
        surgery.setDescription("cirugia");
        Specialty savedSurgery = specialtyService.save(surgery);
        PetType dog = new PetType();

        dog.setName("Perro");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();

        cat.setName("Gato");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType cobaya = new PetType();

        cobaya.setName("Cobaya");
        PetType CobayaSavedPetType = petTypeService.save(cobaya);

        System.out.println("Loaded PetTypes..");


        Owner owner1 = new Owner();

        owner1.setFirstName("Jose");
        owner1.setLastName("Cabezas");
        owner1.setAddress("Ronda de Nelle");
        owner1.setCity("Cordoba");
        owner1.setTelephone("981999999");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Brno");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);
        Owner owner2 = new Owner();

        owner2.setFirstName("ROi");
        owner2.setLastName("Moares");
        owner2.setAddress("Ronda Outeiro");
        owner2.setCity("Malaga");
        owner2.setTelephone("981888888");
        Pet fionaCat = new Pet();
        fionaCat.setPetType(savedCatPetType);
        fionaCat.setName("Kat");
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setOwner(owner2);
        owner2.getPets().add(fionaCat);
        ownerService.save(owner2);
        Owner owner3 = new Owner();
        owner3.setFirstName("Rafael");
        owner3.setLastName("Cabezas");
        owner3.setAddress("Cuatro Caminos");
        owner3.setCity("Sevilla");
        owner3.setTelephone("981777777");
        Pet p = new Pet();
        p.setOwner(owner3);
        p.setBirthDate(LocalDate.now());
        p.setName("Coby");
        p.setPetType(savedCatPetType);

        owner3.getPets().add(p);
        ownerService.save(owner3);
        Visit visit = new Visit();
        visit.setPet(fionaCat);
        visit.setDate(LocalDate.now());
        visit.setDescription("Vacunas");
        visitService.save(visit);

        System.out.println("Loaded owners..");

        Vet vet1 = new Vet();

        vet1.setFirstName("Julio");
        vet1.setLastName("Anguita");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Dolores");
        vet2.setLastName("Ibarruri");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets..");
    }
}
