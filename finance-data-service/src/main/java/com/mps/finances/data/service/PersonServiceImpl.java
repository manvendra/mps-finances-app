package com.mps.finances.data.service;


import com.mps.finances.PersonVo;
import com.mps.finances.data.config.ModelMappingService;
import com.mps.finances.data.repository.jpa.PersonJpaRepository;
import com.mps.finances.data.repository.jpa.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonJpaRepository personJpaRepository;

    @Autowired
    ModelMappingService modelMappingService;


    @Override
    public PersonVo savePerson(PersonVo personVo) {
        Person person = modelMappingService.getPersonEntityFromVo(personVo);
        person = personJpaRepository.save(person);
        return modelMappingService.getPersonVoFromEntity(person);
    }

    @Override
    public PersonVo getPersonById(Long personId)  {
        Person person = personJpaRepository
                .findById(personId)
                .orElseThrow(EntityNotFoundException::new);

        return modelMappingService.getPersonVoFromEntity(person);
    }

    @Override
    public List<PersonVo> getPerson(Map<String, String> requestParams) {

        Map<String, String> personEntityColumnNamesAndValues

                = requestParams
                .entrySet()
                .stream()
                .filter(e -> isaPersonColumn(e))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        List<Person> persons = personJpaRepository.findAll(
                PersonJpaRepository.getSpecification(personEntityColumnNamesAndValues));


        return persons
                .stream()
                .map(modelMappingService::getPersonVoFromEntity)
                .collect(Collectors.toList());
    }

    private boolean isaPersonColumn(Map.Entry<String, String> e) {
        return Arrays
                .stream(Person.class
                                .getDeclaredFields()
                       )
                .anyMatch(f -> f
                        .getName()
                        .equals(e.getKey()));
    }
}
