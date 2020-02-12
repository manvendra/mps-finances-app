package com.mps.finances.data.service;


import com.mps.finances.PersonVo;
import com.mps.finances.data.config.ModelMappingService;
import com.mps.finances.data.repository.jpa.PersonJpaRepository;
import com.mps.finances.data.repository.jpa.entities.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
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
    public List<PersonVo> getPersonByFirstName(String firstName) {
        List<Person> persons = personJpaRepository.findByFirstName(firstName);


        return persons
                .stream()
                .map(modelMappingService::getPersonVoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonVo> getPersonByName(String name) {
        List<Person> persons = personJpaRepository.findByName(name);

        return persons
                .stream()
                .map(modelMappingService::getPersonVoFromEntity)
                .collect(Collectors.toList());

    }
}
