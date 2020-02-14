package com.mps.finances.data.service;

import com.mps.finances.PersonVo;

import java.util.List;
import java.util.Map;

public interface PersonService {


    PersonVo savePerson(PersonVo personVo);

    PersonVo getPersonById(Long personId);

    List<PersonVo> getPerson(Map<String, String> requestParams);
}