package com.mps.finances.trackerservice.service;


import com.mps.finances.account.FinancialAccountVo;

import java.util.List;

public interface FinancialAccountService {

    public List<FinancialAccountVo> getAllAcountsInfo(String name);

}