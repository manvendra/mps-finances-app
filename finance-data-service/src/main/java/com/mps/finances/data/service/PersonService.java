package com.mps.finances.data.service;

import com.mps.finances.PersonVo;

import java.util.List;

public interface PersonService {


    PersonVo savePerson(PersonVo personVo);

    PersonVo getPersonById(Long personId);

    List<PersonVo> getPersonByFirstName(String firstName);
}