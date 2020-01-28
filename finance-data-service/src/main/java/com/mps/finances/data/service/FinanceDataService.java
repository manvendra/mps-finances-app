package com.mps.finances.data.service;

import com.mps.finances.account.FinancialAccount;

import java.util.List;

public interface FinanceDataService {

    List<FinancialAccount> getAllAcountsInfoByFirstName(String accountHolderName);

    List<FinancialAccount> getAllAcountsInfoByAccoutId(Long accountId);

    FinancialAccount getAccountInfo(String accountHolderName, String financialInstitutionName);

    FinancialAccount saveAccountInformation(FinancialAccount financialAccount);

    List<FinancialAccount> getAccountsWithCloseDueDates();
}