package com.mps.finances.data.service;

import com.mps.finances.account.FinancialAccountVo;

import java.util.List;

public interface FinanceDataService {

    List<FinancialAccountVo> getAllAcountsInfoByFirstName(String accountHolderName);

    List<FinancialAccountVo> getAllAcountsInfoByAccoutId(Long accountId);

    FinancialAccountVo getAccountInfo(String accountHolderName, String financialInstitutionName);

    FinancialAccountVo saveAccountInformation(FinancialAccountVo financialAccount);

    List<FinancialAccountVo> getAccountsWithCloseDueDates();
}