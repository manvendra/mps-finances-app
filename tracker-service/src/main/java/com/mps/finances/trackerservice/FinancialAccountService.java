package com.mps.finances.trackerservice;

import com.mps.finances.account.FinancialAccount;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FinancialAccountService {

    public List<FinancialAccount> getAllAcountsInfo(String accountHolderName);

    public FinancialAccount getAccountInfo(String accountHolderName, String financialInstitutionName);

    public long saveAccountInformation(FinancialAccount financialAccount);
}