package com.mps.finances.data.service;


import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.data.config.ModelMappingService;
import com.mps.finances.data.repository.jpa.FinanceDataJpaRepository;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    ModelMappingService modelMappingService;

/*    @Autowired
    FinanceDataCouchbaseRepository financeDataCouchbaseRepository;*/


    @Override
    public List<FinancialAccountVo> getAllAcountsInfoByFirstName(String accountHolderName) {
        log.debug("accountHolderName");
        List<FinancialAccount> financeAccountsEntities = financeDataJpaRepository.findByOwnerFirstName(accountHolderName);

        return getDtoListFromEntityList(financeAccountsEntities);
    }


    @Override
    public List<FinancialAccountVo> getAllAcountsInfoByAccoutId(Long accountId) {
        List<FinancialAccount> financeAccountsEntities = financeDataJpaRepository.findByOwnerId(accountId);

        return getDtoListFromEntityList(financeAccountsEntities);
    }

    @Override
    public FinancialAccountVo getAccountInfo(String accountHolderName, String financialInstitutionName) {
        return null;
    }

    @Override
    public FinancialAccountVo saveAccountInformation(FinancialAccountVo financialAccount) {
        FinancialAccount financialAccountEntity = modelMappingService.getEntityFromVo(financialAccount);
        financialAccountEntity = financeDataJpaRepository.save(financialAccountEntity);
        return modelMappingService.getVoFromEntity(financialAccountEntity);
    }

    @Override
    public List<FinancialAccountVo> getAccountsWithCloseDueDates() {
        return null;
    }


    private List<FinancialAccountVo> getDtoListFromEntityList(List<FinancialAccount> financeAccountsEntities) {
        return financeAccountsEntities.stream()
                                      .map(modelMappingService::getVoFromEntity)
                                      .collect(Collectors.toList());
    }


}
