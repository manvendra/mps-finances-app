package com.mps.finances.data.config;

import com.mps.finances.account.BankAccountVo;
import com.mps.finances.account.CreditCardAccountVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.account.StocksToSellVo;
import com.mps.finances.data.repository.jpa.entities.account.BankAccount;
import com.mps.finances.data.repository.jpa.entities.account.CreditCardAccount;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import com.mps.finances.data.repository.jpa.entities.account.StocksToSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ModelMappingService {

    @Autowired
    @Qualifier("voToEntityModelMapper")
    org.modelmapper.ModelMapper voToEntityModelMapper;

    @Autowired
    @Qualifier("entitytoVoModelMapper")
    org.modelmapper.ModelMapper emtityToVOodelMapper;


    public FinancialAccountVo getVoFromEntity(FinancialAccount financeAccountsEntity) {
        if (financeAccountsEntity instanceof CreditCardAccount) {
            return voToEntityModelMapper.map(financeAccountsEntity, CreditCardAccountVo.class);
        } else if (financeAccountsEntity instanceof BankAccount) {
            return voToEntityModelMapper.map(financeAccountsEntity, BankAccountVo.class);
        } else if (financeAccountsEntity instanceof StocksToSell) {
            return voToEntityModelMapper.map(financeAccountsEntity, StocksToSellVo.class);
        }
        return voToEntityModelMapper.map(financeAccountsEntity, FinancialAccountVo.class);
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

}
