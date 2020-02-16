package com.mps.finances.trackerservice.connectors.data.finance;

import com.mps.finances.account.FinancialAccountVo;

import java.util.List;

public interface FinanceDataConnector {

    List<FinancialAccountVo> getAllFinancialAccountForOwnerId(Long id);
}
