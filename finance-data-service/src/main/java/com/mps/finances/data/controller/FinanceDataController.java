package com.mps.finances.data.controller;

import com.mps.finances.account.FinancialAccount;
import com.mps.finances.data.service.FinanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("data/financialAccount/")
public class FinanceDataController {

    @Autowired
    FinanceDataService financeDataService;

    @GetMapping(value = "/{accountId}")
    public List<FinancialAccount> getAllAccountsForUser(@PathVariable Long accountId) {
        return financeDataService.getAllAcountsInfoByAccoutId(accountId);
    }

    @GetMapping
    public List<FinancialAccount> getAllAccountsForUser(@RequestParam("firstName") String firstName) {
        return financeDataService.getAllAcountsInfoByFirstName(firstName);
    }

    @PostMapping
    public FinancialAccount saveFinancialAccountData(@RequestBody FinancialAccount financialAccount){
       return financeDataService.saveAccountInformation(financialAccount);
    }
}
