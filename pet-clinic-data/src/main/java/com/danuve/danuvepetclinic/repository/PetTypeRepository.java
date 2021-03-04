package com.danuve.danuvepetclinic.repository;

import com.danuve.danuvepetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
