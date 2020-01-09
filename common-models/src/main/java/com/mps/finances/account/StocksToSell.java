package com.mps.finances.account;

import com.mps.finances.types.AccountType;

public class StocksToSell extends FinancialAccount {

    private int    numberOfStock;
    private String StockSymbol;

    public StocksToSell(String SockBroker,String description) {
        super(SockBroker,description, AccountType.STOCK);
    }
}
