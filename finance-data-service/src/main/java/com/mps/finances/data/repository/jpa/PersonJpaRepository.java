package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.jpa.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<Person,Long> {
    List<Person> findByFirstName(String firstName);
}
