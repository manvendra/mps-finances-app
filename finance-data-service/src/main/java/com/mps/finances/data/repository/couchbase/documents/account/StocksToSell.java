package com.mps.finances.data.repository.couchbase.documents.account;


import com.mps.finances.types.AccountType;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class StocksToSell extends FinancialAccount {

    @Id
    @GeneratedValue
    Long id;

    private int    numberOfStock;
    private String StockSymbol;
    {
        setAccountType(AccountType.STOCK);
    }
}
