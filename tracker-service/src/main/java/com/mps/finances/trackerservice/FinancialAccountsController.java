package com.mps.finances.trackerservice;


import com.mps.finances.account.FinancialAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/finances/{accountHolderName}/accounts")
public class FinancialAccountsController {

    @Autowired
    FinancialAccountService financialAccountService;


    @GetMapping("{accountHolderName}/accounts")
    public List<FinancialAccountVo> getAllAcountsInfo(@PathVariable(required = false) String accountHolderName) {
        return financialAccountService.getAllAcountsInfo(accountHolderName);
    }

    @GetMapping("{accountHolderName}/accounts/{FinancialInstitutionName}")
    public FinancialAccountVo getAccountInfo(@PathVariable(required = false) String accountHolderName, @PathVariable String financialInstitutionName) {
        return financialAccountService.getAccountInfo(accountHolderName, financialInstitutionName);
    }

    @PostMapping
    public long saveAccountInformation(@RequestBody FinancialAccountVo financialAccount) {
        return financialAccountService.saveAccountInformation(financialAccount);
    }
}
