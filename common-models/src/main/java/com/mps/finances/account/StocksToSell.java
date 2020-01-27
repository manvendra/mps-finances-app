package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class StocksToSell extends FinancialAccount {


    Long id;

    private int    numberOfStock;
    private String StockSymbol;

    public StocksToSell(String SockBroker, String description) {

        super(SockBroker, description, AccountType.STOCK);
    }
}
