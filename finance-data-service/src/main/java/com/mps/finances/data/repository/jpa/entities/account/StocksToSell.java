package com.mps.finances.data.repository.jpa.entities.account;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("STOCK")
public class StocksToSell extends FinancialAccount {

    private int    numberOfStock;
    private String StockSymbol;

}
