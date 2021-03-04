package com.danuve.danuvepetclinic.repository;

import com.danuve.danuvepetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
