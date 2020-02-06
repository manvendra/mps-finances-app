package com.mps.finances.data.service;


import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.data.config.ModelMappingService;
import com.mps.finances.data.repository.jpa.FinanceDataJpaRepository;
import com.mps.finances.data.repository.jpa.PersonJpaRepository;
import com.mps.finances.data.repository.jpa.entities.Person;
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
    PersonJpaRepository personJpaRepository;

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
    public FinancialAccountVo saveFinancialAccount(FinancialAccountVo financialAccount) {
        FinancialAccount financialAccountEntity = modelMappingService.getEntityFromVo(financialAccount);
        updateInternalEntities(financialAccountEntity);
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

    // if entity containable.getCompound already exists, it
    // must first be reattached to the entity manager or else
    // an exception will occur (issue in Spring Data JPA ->
    // save() method internal calls persists instead of merge)
    private void updateInternalEntities(FinancialAccount financialAccountEntity) {
        if (financialAccountEntity.getId() == null && financialAccountEntity.getOwner()
                                                                            .getId() != null) {
            Person ownerEntity = financialAccountEntity.getOwner();

            ownerEntity = personJpaRepository.findById(ownerEntity.getId())
                                             .orElse(ownerEntity);


            ownerEntity.setEmail(financialAccountEntity.getOwner()
                                                       .getEmail());
            ownerEntity.setPhone(financialAccountEntity.getOwner()
                                                       .getPhone());
            ownerEntity.setFirstName(financialAccountEntity.getOwner()
                                                           .getFirstName());
            ownerEntity.setLastName(financialAccountEntity.getOwner()
                                                          .getLastName());


            financialAccountEntity.setOwner(ownerEntity);
        }
    }
}
