package com.mps.finances.trackerservice.service;


import com.mps.finances.account.FinancialAccountVo;

import java.util.List;

public interface FinancialAccountService {

    List<FinancialAccountVo> getAllAccountsInfo(Long id);

}