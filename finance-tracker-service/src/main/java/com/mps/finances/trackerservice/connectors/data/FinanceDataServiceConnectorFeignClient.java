package com.mps.finances.trackerservice.connectors.data;

import com.mps.finances.PersonVo;
import com.mps.finances.account.FinancialAccountVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("finance-data-service")
public interface FinanceDataServiceConnectorFeignClient {

    @RequestMapping(value = "/data/owners" , method = RequestMethod.GET)
    List<PersonVo> getPersonByName(@RequestParam("name") String name);

    @RequestMapping(value = "/data/owners/{ownerId}" , method = RequestMethod.GET)
    List<PersonVo> getPersonById(@PathVariable("ownerId") String id);




    @RequestMapping(value = "/data/owners/{ownerId}/financialAccounts" , method = RequestMethod.GET)
    List<FinancialAccountVo> getAllFinancialAccountForOwnerId(@PathVariable("ownerId") Long id);



}
