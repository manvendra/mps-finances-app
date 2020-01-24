package com.mps.finances.trackerservice;


import com.mps.finances.account.FinancialAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController("/finances/{accountHolderName}/accounts")
public class FinancialAccountsController {

    @Autowired
    FinancialAccountService financialAccountService;


    @GetMapping("{accountHolderName}/accounts")
    public List<FinancialAccount> getAllAcountsInfo(@PathVariable(required = false) String accountHolderName) {
       return financialAccountService.getAllAcountsInfo(accountHolderName);
    }

    @GetMapping("{accountHolderName}/accounts/{FinancialInstitutionName}")
    public FinancialAccount getAccountInfo(@PathVariable(required =false) String accountHolderName,@PathVariable String financialInstitutionName){
       return  financialAccountService.getAccountInfo(accountHolderName,financialInstitutionName);
    }

    @PostMapping
    public long saveAccountInformation(@RequestBody FinancialAccount financialAccount){
        return financialAccountService.saveAccountInformation(financialAccount);
    }
}
