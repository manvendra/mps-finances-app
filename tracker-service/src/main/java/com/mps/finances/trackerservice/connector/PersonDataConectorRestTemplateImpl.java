package com.mps.finances.trackerservice.connector;

import com.mps.finances.PersonVo;
import com.mps.finances.trackerservice.config.BackendServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("personRestTemplateConnector")
public class PersonDataConectorRestTemplateImpl implements PersonDataConnector {

    @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    BackendServiceConfig backendServiceConfig;


    @Override
    public PersonVo getPersonById(Long id) {
        ResponseEntity<PersonVo> responseEntity = restTemplate.getForEntity(
                backendServiceConfig.personUrl, PersonVo.class); return responseEntity.getBody();
    }

    @Override
    public List<PersonVo> getPersonsByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<PersonVo> getPersonByName(String name) {
        return null;
    }
}
