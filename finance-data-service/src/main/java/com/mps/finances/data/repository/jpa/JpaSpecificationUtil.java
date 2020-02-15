package com.mps.finances.data.repository.jpa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class JpaSpecificationUtil<T> {

    public Specification<T> has(Map.Entry<String, String> entry) {
        return (t, cq, cb) -> cb.equal(t.get(entry.getKey()), entry.getValue());
    }

    public Specification<T> getSpecification(Map<String, String> columnNamesAndValues) {
        return columnNamesAndValues
                .entrySet()
                .stream()
                .map(this::has)
                .reduce((spec1, spec2) -> spec1.and(spec2))
                .orElse(null);
    }


    public boolean isaValidColumnName(Map.Entry<String, String> entry,
                                      Class entityClass) {
        return Arrays
                .stream(entityClass.getDeclaredFields())
                .anyMatch(field -> field
                        .getName()
                        .equals(entry.getKey()));
    }
}
