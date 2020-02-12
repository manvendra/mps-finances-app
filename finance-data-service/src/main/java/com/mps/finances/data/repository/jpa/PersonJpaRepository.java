package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.jpa.entities.Person;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<Person,Long> {
    List<Person> findByFirstName(String firstName);

    @Query("SELECT p FROM Person p " +
           "WHERE  (LOWER(p.lastName) = LOWER(:name)) " +
           "OR  (LOWER(p.firstName) = LOWER(:name))")
    List<Person> findByName(String name);

}
