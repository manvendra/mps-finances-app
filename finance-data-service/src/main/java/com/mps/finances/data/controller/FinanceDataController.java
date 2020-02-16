package com.mps.finances.data.controller;

import com.mps.finances.PersonVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.data.service.FinanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/data/owners/{ownerId}/financialAccounts")
public class FinanceDataController {

    @Autowired
    FinanceDataService financeDataService;


    @GetMapping
    public ResponseEntity<List<FinancialAccountVo>> getAllAccountsForOwner(@PathVariable("ownerId") Long ownerId,
                                                                           @RequestParam Map<String, String> requestParams) {

        List<FinancialAccountVo> financialAccountVos =
                financeDataService.getFinancialAccounts(ownerId,requestParams);

        return ResponseEntity.ok(financialAccountVos);
    }



    @PostMapping
    public ResponseEntity<FinancialAccountVo> saveFinancialAccountVo(@PathVariable("ownerId") Long ownerId,
                                                                     @RequestBody FinancialAccountVo financialAccountVo) {

        setUpOwnerIfAbsent(ownerId, financialAccountVo);

        financialAccountVo = financeDataService.saveFinancialAccount(financialAccountVo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(financialAccountVo);
    }


    @PostMapping(value = "/batch")
    public ResponseEntity<List<FinancialAccountVo>> saveListOfFinancialAccountVo(@PathVariable("ownerId") Long ownerId,
                                                                                 @RequestBody List<FinancialAccountVo> financialAccountVos) {
        financialAccountVos = Optional
                .of(financialAccountVos)
                .orElse(Collections.emptyList())
                .stream()
                .peek(e -> setUpOwnerIfAbsent(ownerId, e))
                .collect(Collectors.toList());

        financialAccountVos = financeDataService.saveFinancialAccounts(financialAccountVos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(financialAccountVos);
    }

    @DeleteMapping(value = "/{financialAccountId}")
    ResponseEntity deleteFinancialAccountById(@PathVariable("financialAccountId") Long financialAccountId) {
        financeDataService.deleteFinancialAccount(financialAccountId);

        return ResponseEntity
                .noContent()
                .build();
    }

    private void setUpOwnerIfAbsent(Long accountId,
                                    FinancialAccountVo financialAccountVo) {
        if (financialAccountVo.getOwner() == null) {
            PersonVo owner = new PersonVo(); owner.setId(accountId);
            financialAccountVo.setOwner(owner);
        }
    }
}
