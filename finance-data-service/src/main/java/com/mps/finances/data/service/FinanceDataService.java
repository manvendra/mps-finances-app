package com.mps.finances.data.service;

import com.mps.finances.account.FinancialAccountVo;

import java.util.List;
import java.util.Map;

public interface FinanceDataService {

    List<FinancialAccountVo> getAllAcountsInfoByFirstName(String accountHolderName);

    List<FinancialAccountVo> getAllAcountsInfoByAccoutId(Long accountId);

    public List<FinancialAccountVo> getFinancialAccounts(Long ownerId,
                                                         Map<String, String> requestParams);

    FinancialAccountVo getAccountInfo(String accountHolderName,
                                      String financialInstitutionName);

    FinancialAccountVo saveFinancialAccount(FinancialAccountVo financialAccount);

    List<FinancialAccountVo> saveFinancialAccounts(List<FinancialAccountVo> financialAccountVos);

    List<FinancialAccountVo> getAccountsWithCloseDueDates();

    void deleteFinancialAccount(Long financialAccountId);
}