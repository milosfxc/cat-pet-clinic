package com.danuve.danuvepetclinic.bootstrap;

import com.danuve.danuvepetclinic.model.*;
import com.danuve.danuvepetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }




    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) LoadData();


    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Cvelf");
        owner1.setAddress("5th Avenue");
        owner1.setCity("New York");
        owner1.setTelephone("65464654");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Bucko");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Elena");
        owner2.setLastName("Rago");
        owner2.setAddress("Hlw Bulevard");
        owner2.setCity("Belgrade");
        owner2.setTelephone("6546464");

        Pet elenasCat = new Pet();
        elenasCat.setPetType(savedCatPetType);
        elenasCat.setOwner(owner2);
        elenasCat.setBirthDate(LocalDate.now());
        elenasCat.setName("Macka");
        owner2.getPets().add(elenasCat);

        Visit catVisit = new Visit();
        catVisit.setDescription("Sneezy Kitty");
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(elenasCat);



        ownerService.save(owner2);
        visitService.save(catVisit);
        Vet vet1 = new Vet();
        vet1.setFirstName("Nina");
        vet1.setLastName("Pantic");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedDentistry);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nikola");
        vet2.setLastName("Arsic");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedSurgery);

        System.out.println("Loaded data...");
    }


}
