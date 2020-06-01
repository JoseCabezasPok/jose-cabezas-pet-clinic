package com.example.josecabezaspetclinic.services.springdatajpa;

import com.example.josecabezaspetclinic.model.Owner;
import com.example.josecabezaspetclinic.repositories.OwnerRepository;
import com.example.josecabezaspetclinic.repositories.PetRepository;
import com.example.josecabezaspetclinic.repositories.PetTypeRepository;
import com.example.josecabezaspetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long aLong) {
       Optional<Owner> ownerOptional = ownerRepository.findById(aLong);
       return ownerOptional.orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public void delete(Owner object) {
            ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
            ownerRepository.deleteById(aLong);
    }
}
