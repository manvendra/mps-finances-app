package com.mps.finances.trackerservice.service;

import com.mps.finances.PersonVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.trackerservice.connector.data.person.PersonDataConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FinancialAccountServiceImpl implements FinancialAccountService {


    @Autowired
    PersonDataConnector PersonDataConnector;

    @Override
    public List<FinancialAccountVo> getAllAccountsInfo(String name) {

        List<PersonVo> personVos = PersonDataConnector.getPersonByName(name);


        return null;
    }
}
