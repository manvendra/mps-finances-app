package com.mps.finances.trackerservice.connectors.data.person;

import com.mps.finances.PersonVo;
import com.mps.finances.trackerservice.connectors.data.FinanceDataServiceConnectorFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(name = "person.data.feign.client.enabled", havingValue = "true")
public class PersonDataConnectorImpl implements PersonDataConnector {

    @Autowired
    FinanceDataServiceConnectorFeignClient personDataConnectorFeignClient;


    @Override
    public PersonVo getPersonById(Long id) {
        return null;
    }

    @Override
    public List<PersonVo> getPersonsByFirstName(String firstName) {
        return null;
    }


    @Override
    public List<PersonVo> getPersonByName(String name) {
        return personDataConnectorFeignClient.getPersonByName(name);
    }


}




