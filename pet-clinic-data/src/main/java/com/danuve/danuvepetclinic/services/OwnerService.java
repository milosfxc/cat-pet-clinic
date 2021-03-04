package com.danuve.danuvepetclinic.services;

import com.danuve.danuvepetclinic.model.Owner;

public interface OwnerService extends CrudRepository<Owner,Long>{
    Owner findByLastName(String lastName);
}
