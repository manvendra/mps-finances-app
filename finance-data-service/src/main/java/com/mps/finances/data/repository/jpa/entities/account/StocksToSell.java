package com.mps.finances.data.repository.jpa.entities.account;

import com.mps.finances.types.AccountType;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@DiscriminatorValue("STOCK")
public class StocksToSell extends FinancialAccount {

    private int    numberOfStock;
    private String StockSymbol;

}
