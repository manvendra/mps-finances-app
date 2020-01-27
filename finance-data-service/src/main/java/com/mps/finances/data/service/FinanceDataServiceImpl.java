package com.mps.finances.data.service;


import com.mps.finances.account.FinancialAccount;
import com.mps.finances.data.repository.jpa.FinanceDataJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FinanceDataServiceImpl implements FinanceDataService {

  /*  @Autowired
    FinanceDataRepository financeDataRepository;*/

    @Autowired
    FinanceDataJpaRepository financeJpaRepository;

/*    @Autowired
    FinanceDataCouchbaseRepository financeDataCouchbaseRepository;*/

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<FinancialAccount> getAllAcountsInfoByFirstName(String accountHolderName) {

        List<com.mps.finances.data.repository.jpa.entities.account.FinancialAccount> financeAccountsEntities = financeJpaRepository.findByPersonFirstName(accountHolderName);

        return getDtoFromEntity(financeAccountsEntities);
    }

    @Override
    public List<FinancialAccount> getAllAcountsInfoByAccoutId(Long accountId) {
        List<com.mps.finances.data.repository.jpa.entities.account.FinancialAccount> financeAccountsEntities = financeJpaRepository.findByPersonPersonId(accountId);

        return getDtoFromEntity(financeAccountsEntities);
    }

    @Override
    public FinancialAccount getAccountInfo(String accountHolderName, String financialInstitutionName) {
        return null;
    }

    @Override
    public long saveAccountInformation(FinancialAccount financialAccount) {
        return 0;
    }

    @Override
    public List<FinancialAccount> getAccountsWithCloseDueDates() {
        return null;
    }

    private List<FinancialAccount> getDtoFromEntity(List<com.mps.finances.data.repository.jpa.entities.account.FinancialAccount> financeAccountsEntities) {
        return financeAccountsEntities.stream()
                                      .map(e -> modelMapper.map(e, FinancialAccount.class))
                                      .collect(Collectors.toList());
    }
}
