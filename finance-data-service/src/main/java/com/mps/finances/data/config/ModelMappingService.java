package com.mps.finances.data.config;

import com.mps.finances.PersonVo;
import com.mps.finances.account.BankAccountVo;
import com.mps.finances.account.CreditCardAccountVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.account.StocksToSellVo;
import com.mps.finances.data.repository.jpa.entities.Person;
import com.mps.finances.data.repository.jpa.entities.account.BankAccount;
import com.mps.finances.data.repository.jpa.entities.account.CreditCardAccount;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import com.mps.finances.data.repository.jpa.entities.account.StocksToSell;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMappingService {

    @Autowired
    ModelMapper modelMapper;

    @Bean
    public ModelMapper getCustomModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

       /* modelMapper
                .createTypeMap(FinancialAccountVo.class, FinancialAccount.class)
                .include(BankAccountVo.class, FinancialAccount.class)
                .include(CreditCardAccountVo.class, FinancialAccount.class)
                .include(StocksToSellVo.class, FinancialAccount.class);


        modelMapper
                .typeMap(BankAccountVo.class, FinancialAccount.class)
                .setProvider(new Provider<FinancialAccount>() {
                    public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
                        return new BankAccount();
                    }
                }); modelMapper
                .typeMap(CreditCardAccountVo.class, FinancialAccount.class)
                .setProvider(new Provider<FinancialAccount>() {
                    public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
                        return new CreditCardAccount();
                    }
                }); modelMapper
                .typeMap(StocksToSellVo.class, FinancialAccount.class)
                .setProvider(new Provider<FinancialAccount>() {
                    public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
                        return new StocksToSell();
                    }
                });*/


        return modelMapper;
    }

    public FinancialAccountVo getFinancialAccountVoFromEntity(FinancialAccount financeAccountsEntity) {
        if (financeAccountsEntity instanceof CreditCardAccount) {
            return modelMapper.map(financeAccountsEntity, CreditCardAccountVo.class);
        } else if (financeAccountsEntity instanceof BankAccount) {
            return modelMapper.map(financeAccountsEntity, BankAccountVo.class);
        } else if (financeAccountsEntity instanceof StocksToSell) {
            return modelMapper.map(financeAccountsEntity, StocksToSellVo.class);
        } return modelMapper.map(financeAccountsEntity, FinancialAccountVo.class);
    }


    public FinancialAccount getFinancialAccountEntityFromVo(FinancialAccountVo financialAccountVo) {

        if (financialAccountVo instanceof CreditCardAccountVo) {
            return modelMapper.map(financialAccountVo, CreditCardAccount.class);
        } else if (financialAccountVo instanceof BankAccountVo) {
            return modelMapper.map(financialAccountVo, BankAccount.class);
        } else if (financialAccountVo instanceof StocksToSellVo) {
            return modelMapper.map(financialAccountVo, StocksToSell.class);
        }

        return modelMapper.map(financialAccountVo, FinancialAccount.class);
    }

    public List<FinancialAccountVo> getFinancialAccountVoListFromEntityList(List<FinancialAccount> financeAccountsEntities) {
        return financeAccountsEntities
                .stream()
                .map(this::getFinancialAccountVoFromEntity)
                .collect(Collectors.toList());
    }

    public List<FinancialAccount> getFinancialAccountEntityListFromVoList(List<FinancialAccountVo> financeAccountVos) {
        return financeAccountVos
                .stream()
                .map(this::getFinancialAccountEntityFromVo)
                .collect(Collectors.toList());
    }


    public Person getPersonEntityFromVo(PersonVo personVo) {
        return modelMapper.map(personVo, Person.class);
    }

    public PersonVo getPersonVoFromEntity(Person person) {
        return modelMapper.map(person, PersonVo.class);
    }
}
