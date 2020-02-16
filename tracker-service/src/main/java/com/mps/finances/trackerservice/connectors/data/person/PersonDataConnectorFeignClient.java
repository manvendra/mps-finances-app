package com.mps.finances.trackerservice.connectors.data.person;

import com.mps.finances.PersonVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("finance-data-service")
public interface PersonDataConnectorFeignClient {

    @RequestMapping(value = "/data/owners" , method = RequestMethod.GET)
    List<PersonVo> getPersonByName(@RequestParam("name") String name);

}
