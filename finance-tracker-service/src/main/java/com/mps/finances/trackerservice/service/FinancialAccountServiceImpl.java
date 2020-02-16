package com.mps.finances.trackerservice.service;

import com.mps.finances.PersonVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.trackerservice.connectors.data.finance.FinanceDataConnector;
import com.mps.finances.trackerservice.connectors.data.person.PersonDataConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class FinancialAccountServiceImpl implements FinancialAccountService {


    @Autowired
    PersonDataConnector personDataConnector;

    @Autowired
    FinanceDataConnector financeDataConnector;

    @Override
    public List<FinancialAccountVo> getAllAccountsInfo(Long id) {

        PersonVo                 personVo            = personDataConnector.getPersonById(id);
        List<FinancialAccountVo> financialAccountVos = financeDataConnector.getAllFinancialAccountForOwnerId(id);

        return financialAccountVos
                .stream()
                .peek(financialAccountVo -> financialAccountVo.setOwner(personVo))
                .collect(Collectors.toList());

    }
}
