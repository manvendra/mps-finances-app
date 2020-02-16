package com.mps.finances.trackerservice.connectors.data.finance;

import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.trackerservice.connectors.data.FinanceDataServiceConnectorFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FinanceDataConnectorImpl implements FinanceDataConnector {

    @Autowired
    FinanceDataServiceConnectorFeignClient financeDataFeignClient;

    @Override
    public List<FinancialAccountVo> getAllFinancialAccountForOwnerId(Long id) {
        return financeDataFeignClient.getAllFinancialAccountForOwnerId(id);
    }


}
