package com.mps.finances.trackerservice.controller;


import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.trackerservice.service.FinancialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finances/{ownerId}")
public class FinancialAccountsController {

    @Autowired
    FinancialAccountService financialAccountService;

    @GetMapping(value = "/accounts")
    public List<FinancialAccountVo> getAllAcountsInfo(@PathVariable("ownerId") Long ownerId) {
        return financialAccountService.getAllAccountsInfo(ownerId);
    }


}
