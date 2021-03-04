package com.danuve.danuvepetclinic.services;

import java.util.Set;

public interface CrudRepository<T, ID> {
    Set<T> findAll();
    T findById(ID Id);
    T save(T object);
    void delete(T object);
    void deleteById(ID Id);

}
