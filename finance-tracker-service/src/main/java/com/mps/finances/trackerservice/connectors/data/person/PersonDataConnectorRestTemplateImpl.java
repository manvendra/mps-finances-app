package com.mps.finances.trackerservice.connectors.data.person;

import com.mps.finances.PersonVo;
import com.mps.finances.trackerservice.config.BackendServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("personRestTemplateConnector")
@ConditionalOnMissingBean(PersonDataConnector.class)
public class PersonDataConnectorRestTemplateImpl implements PersonDataConnector {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BackendServiceConfig backendServiceConfig;


    @Override
    public PersonVo getPersonById(Long id) {
        ResponseEntity<PersonVo> responseEntity = restTemplate.getForEntity(
                backendServiceConfig.personDataServiceURL, PersonVo.class);
        return responseEntity.getBody();
    }

    @Override
    public List<PersonVo> getPersonsByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<PersonVo> getPersonByName(String name) {
        String         url            = backendServiceConfig.personDataServiceURL + "/data/owners/name/" + name;
        ResponseEntity responseEntity = restTemplate.getForEntity(url, List.class);

        return null;
    }
}
