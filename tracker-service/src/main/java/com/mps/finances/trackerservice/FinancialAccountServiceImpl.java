package com.mps.finances.trackerservice;

import com.mps.finances.account.FinancialAccount;

import java.util.List;

public class FinancialAccountServiceImpl implements FinancialAccountService {


    @Override
    public List<FinancialAccount> getAllAcountsInfo(String accountHolderName) {
        return null;
    }

    @Override
    public FinancialAccount getAccountInfo(String accountHolderName, String financialInstitutionName) {
        return null;
    }

    @Override
    public long saveAccountInformation(FinancialAccount financialAccount) {
        FinancialAccount financialAccount1 = financialAccountRepository.save(financialAccount); return 0;
    }
}
