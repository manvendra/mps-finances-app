package com.mps.finances.data.config;

import com.mps.finances.account.BankAccountVo;
import com.mps.finances.account.CreditCardAccountVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.account.StocksToSellVo;
import com.mps.finances.data.repository.jpa.entities.account.BankAccount;
import com.mps.finances.data.repository.jpa.entities.account.CreditCardAccount;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import com.mps.finances.data.repository.jpa.entities.account.StocksToSell;
import com.mps.finances.data.service.FinanceDataServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMappingService {

    @Autowired
    @Qualifier("voToEntityModelMapper")
    org.modelmapper.ModelMapper voToEntityModelMapper;

    @Autowired
    @Qualifier("entitytoVoModelMapper")
    org.modelmapper.ModelMapper emtityToVOodelMapper;


    @Bean(name = "voToEntityModelMapper")
    public ModelMapper getVoToEntityModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(FinancialAccountVo.class, FinancialAccount.class)
                   .include(BankAccountVo.class, FinancialAccount.class)
                   .include(CreditCardAccountVo.class, FinancialAccount.class)
                   .include(StocksToSellVo.class, FinancialAccount.class);


        modelMapper.typeMap(BankAccountVo.class, FinancialAccount.class)
                   .setProvider(new Provider<FinancialAccount>() {
                       public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
                           return new BankAccount();
                       }
                   }); modelMapper.typeMap(CreditCardAccountVo.class, FinancialAccount.class)
                                  .setProvider(new Provider<FinancialAccount>() {
                                      public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
                                          return new CreditCardAccount();
                                      }
                                  });
        modelMapper.typeMap(StocksToSellVo.class, FinancialAccount.class)
                   .setProvider(new Provider<FinancialAccount>() {
                       public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
                           return new StocksToSell();
                       }
                   });


        return modelMapper;
    }


    @Bean(name = "entitytoVoModelMapper")
    public ModelMapper getEntitytoVoModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(FinancialAccount.class, FinancialAccountVo.class)
                   .include(BankAccount.class, FinancialAccountVo.class)
                   .include(CreditCardAccount.class, FinancialAccountVo.class)
                   .include(StocksToSell.class, FinancialAccountVo.class);


        modelMapper.typeMap(BankAccount.class, FinancialAccountVo.class)
                   .setProvider(new Provider<FinancialAccountVo>() {
                       public FinancialAccountVo get(ProvisionRequest<FinancialAccountVo> request) {
                           return new BankAccountVo();
                       }
                   }); modelMapper.typeMap(CreditCardAccount.class, FinancialAccountVo.class)
                                  .setProvider(new Provider<FinancialAccountVo>() {
                                      public FinancialAccountVo get(ProvisionRequest<FinancialAccountVo> request) {
                                          return new CreditCardAccountVo();
                                      }
                                  });
        modelMapper.typeMap(StocksToSell.class, FinancialAccountVo.class)
                   .setProvider(new Provider<FinancialAccountVo>() {
                       public FinancialAccountVo get(ProvisionRequest<FinancialAccountVo> request) {
                           return new StocksToSellVo();
                       }
                   });


        return modelMapper;
    }

    public FinancialAccountVo getVoFromEntity(FinancialAccount financeAccountsEntity) {
        if (financeAccountsEntity instanceof CreditCardAccount) {
            return voToEntityModelMapper.map(financeAccountsEntity, CreditCardAccountVo.class);
        } else if (financeAccountsEntity instanceof BankAccount) {
            return voToEntityModelMapper.map(financeAccountsEntity, BankAccountVo.class);
        } else if (financeAccountsEntity instanceof StocksToSell) {
            return voToEntityModelMapper.map(financeAccountsEntity, StocksToSellVo.class);
        } return voToEntityModelMapper.map(financeAccountsEntity, FinancialAccountVo.class);
    }


    public FinancialAccount getEntityFromVo(FinancialAccountVo financialAccountVo) {

        if (financialAccountVo instanceof CreditCardAccountVo) {
            return voToEntityModelMapper.map(financialAccountVo, CreditCardAccount.class);
        } else if (financialAccountVo instanceof BankAccountVo) {
            return voToEntityModelMapper.map(financialAccountVo, BankAccount.class);
        } else if (financialAccountVo instanceof StocksToSellVo) {
            return voToEntityModelMapper.map(financialAccountVo, StocksToSell.class);
        }

        return voToEntityModelMapper.map(financialAccountVo, FinancialAccount.class);
    }

    public List<FinancialAccountVo> getVoListFromEntityList(List<FinancialAccount> financeAccountsEntities) {
        return financeAccountsEntities.stream()
                                      .map(this::getVoFromEntity)
                                      .collect(Collectors.toList());
    }

    public List<FinancialAccount> getEntityListFromVoList(List<FinancialAccountVo> financeAccountVos) {
        return financeAccountVos.stream()
                                      .map(this::getEntityFromVo)
                                      .collect(Collectors.toList());
    }
}
