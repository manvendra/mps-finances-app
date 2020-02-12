package com.mps.finances.trackerservice.controller;


import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.trackerservice.service.FinancialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/finances")
public class FinancialAccountsController {

    @Autowired
    FinancialAccountService financialAccountService;


    @GetMapping("/{accountHolderName}/accounts")
    public List<FinancialAccountVo> getAllAcountsInfo(@PathVariable(required = true) String accountHolderName) {
        return financialAccountService.getAllAcountsInfo(accountHolderName);
    }


}
