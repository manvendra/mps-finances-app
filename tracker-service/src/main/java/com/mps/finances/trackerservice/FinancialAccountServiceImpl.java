package com.mps.finances.trackerservice;

import com.mps.finances.account.FinancialAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FinancialAccountServiceImpl implements FinancialAccountService {

    @Autowired
    FinancialAccountRepository financialAccountRepository;

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
        FinancialAccount financialAccount1 = financialAccountRepository.save(financialAccount);

    }
}
