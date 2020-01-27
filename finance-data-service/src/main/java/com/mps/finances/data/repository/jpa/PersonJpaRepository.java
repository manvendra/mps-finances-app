package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.jpa.entities.Person;

import java.util.List;

public interface PersonJpaRepository {
    List<Person> findByFirstName(String firstName);
}
