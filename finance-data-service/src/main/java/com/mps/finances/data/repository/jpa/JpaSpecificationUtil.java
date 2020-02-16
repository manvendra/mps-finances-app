package com.mps.finances.data.repository.jpa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class JpaSpecificationUtil<T> {

    public Specification<T> has(Map.Entry<String, String> entry) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue());
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
                                      Class... entityClasses) {
        List<Field> fields = new ArrayList<>();

        for(Class entityClass: entityClasses){
            fields.addAll(Arrays.asList(entityClass.getDeclaredFields()));
        }
        return fields
                .stream()
                .anyMatch(field -> field
                        .getName()
                        .equals(entry.getKey()));
    }
}
