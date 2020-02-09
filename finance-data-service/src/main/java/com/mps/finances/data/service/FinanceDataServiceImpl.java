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


    @Autowired
    FinanceDataJpaRepository financeDataJpaRepository;

    @Autowired
    ModelMappingService modelMappingService;




    @Override
    public List<FinancialAccountVo> getAllAcountsInfoByFirstName(String accountHolderName) {
        List<FinancialAccount> financeAccountsEntities = financeDataJpaRepository.findByOwnerFirstName(accountHolderName);
        return modelMappingService.getFinancialAccountVoListFromEntityList(financeAccountsEntities);
    }

    @Override
    public List<FinancialAccountVo> getAllAcountsInfoByAccoutId(Long accountId) {
        List<FinancialAccount> financeAccountsEntities = financeDataJpaRepository.findByOwnerId(accountId);
        return modelMappingService.getFinancialAccountVoListFromEntityList(financeAccountsEntities);
    }



    @Override
    public FinancialAccountVo getAccountInfo(String accountHolderName, String financialInstitutionName) {
        return null;
    }


    @Override
    public FinancialAccountVo saveFinancialAccount(FinancialAccountVo financialAccount) {
        FinancialAccount financialAccountEntity = modelMappingService.getFinancialAccountEntityFromVo(
                financialAccount);
        financialAccountEntity = financeDataJpaRepository.save(financialAccountEntity);
        return modelMappingService.getFinancialAccountVoFromEntity(financialAccountEntity);
    }

    @Override
    public List<FinancialAccountVo> saveFinancialAccounts(List<FinancialAccountVo> financialAccountVos) {
        List<FinancialAccount> financialAccounts = modelMappingService.getFinancialAccountEntityListFromVoList(
                financialAccountVos);

        financialAccounts = financeDataJpaRepository.saveAll(financialAccounts);

        return financialAccounts
                .parallelStream()
                .map(modelMappingService::getFinancialAccountVoFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFinancialAccount(Long financialAccountId) {
        financeDataJpaRepository.deleteById(financialAccountId);
    }


    @Override
    public List<FinancialAccountVo> getAccountsWithCloseDueDates() {
        return null;
    }
}
