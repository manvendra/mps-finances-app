package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.jpa.entities.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface PersonJpaRepository extends JpaRepository<Person, Long>,
                                             JpaSpecificationExecutor<Person> {
    List<Person> findByFirstName(String firstName);


    @Query("SELECT p FROM Person p " + "WHERE  (LOWER(p.lastName) = LOWER(:name)) " + "OR  (LOWER(p.firstName) = LOWER(:name))")
    List<Person> findAllPersonContainingName(@Param("name") String name);
}
