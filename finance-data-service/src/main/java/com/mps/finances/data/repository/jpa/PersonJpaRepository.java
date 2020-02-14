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


    static Specification<Person> has(Map.Entry<String, String> entry) {
        return (person, cq, cb) -> cb.equal(person.get(entry.getKey()), entry.getValue());
    }

    public static Specification<Person> getSpecification(Map<String, String> columnNamesAndValues) {
        return columnNamesAndValues
                .entrySet()
                .stream()
                .map(PersonJpaRepository::has)
                .reduce((spec1, spec2) -> spec1.and(spec2))
                .orElse(null);
    }


    @Query("SELECT p FROM Person p " + "WHERE  (LOWER(p.lastName) = LOWER(:name)) " + "OR  (LOWER(p.firstName) = LOWER(:name))")
    List<Person> findAllPersonContainingName(@Param("name") String name);
}
