package com.mps.finances.trackerservice.connector.data.person;

import com.mps.finances.PersonVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("finance-data-service")
public interface PersonDataConnectorFeignClient {
    @RequestMapping(value = "/data/owners/name/{name}" , method = RequestMethod.GET)
    List<PersonVo> getPersonByName(@PathVariable("name") String name);

}
