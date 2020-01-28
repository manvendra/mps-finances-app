package com.mps.finances.data.service;


import com.mps.finances.account.FinancialAccount;
import com.mps.finances.data.repository.jpa.FinanceDataJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class FinanceDataServiceImpl implements FinanceDataService {

  /*  @Autowired
    FinanceDataRepository financeDataRepository;*/

    @Autowired
    FinanceDataJpaRepository financeDataJpaRepository;

/*    @Autowired
    FinanceDataCouchbaseRepository financeDataCouchbaseRepository;*/

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<FinancialAccount> getAllAcountsInfoByFirstName(String accountHolderName) {
        log.debug("accountHolderName");
        List<com.mps.finances.data.repository.jpa.entities.account.FinancialAccount> financeAccountsEntities
                = financeDataJpaRepository.findByPersonFirstName(accountHolderName);

        return getDtoListFromEntityList(financeAccountsEntities);
    }



    @Override
    public List<FinancialAccount> getAllAcountsInfoByAccoutId(Long accountId) {
        List<com.mps.finances.data.repository.jpa.entities.account.FinancialAccount> financeAccountsEntities
                = financeDataJpaRepository.findByPersonId(accountId);

        return getDtoListFromEntityList(financeAccountsEntities);
    }

    @Override
    public FinancialAccount getAccountInfo(String accountHolderName, String financialInstitutionName) {
        return null;
    }

    @Override
    public FinancialAccount saveAccountInformation(FinancialAccount financialAccount) {
        com.mps.finances.data.repository.jpa.entities.account.FinancialAccount financialAccountEntity =
                getEntityFromDto(financialAccount);
        financialAccountEntity= financeDataJpaRepository.save(financialAccountEntity);
        return getDtoFromEntity(financialAccountEntity);
    }

    @Override
    public List<FinancialAccount> getAccountsWithCloseDueDates() {
        return null;
    }




    private List<FinancialAccount> getDtoListFromEntityList(List<com.mps.finances.data.repository.jpa.entities.account.FinancialAccount> financeAccountsEntities) {
        return financeAccountsEntities.stream()
                                      .map(this::getDtoFromEntity)
                                      .collect(Collectors.toList());
    }
    private FinancialAccount getDtoFromEntity(com.mps.finances.data.repository.jpa.entities.account.FinancialAccount financeAccountsEntities) {
        return  modelMapper.map(financeAccountsEntities, FinancialAccount.class);
    }

    private com.mps.finances.data.repository.jpa.entities.account.FinancialAccount
    getEntityFromDto(FinancialAccount financeAccountDto) {
        return modelMapper.map(
                financeAccountDto,
                com.mps.finances.data.repository.jpa.entities.account.FinancialAccount.class);
    }


}
