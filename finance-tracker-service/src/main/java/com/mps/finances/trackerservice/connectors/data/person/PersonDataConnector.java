package com.mps.finances.trackerservice.connectors.data.person;

import com.mps.finances.PersonVo;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

public interface PersonDataConnector {

    PersonVo getPersonById(Long id);

    List<PersonVo> getPersonsByFirstName(String firstName);
    List<PersonVo> getPersonByName(String name);

    @ConfigurationProperties
    class PersonDataServiceProperties{
       public static String serviceName;
    }
}
