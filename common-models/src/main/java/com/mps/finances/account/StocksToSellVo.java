package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class StocksToSellVo extends FinancialAccountVo {


    Long id;

    private int    numberOfStock;
    private String StockSymbol;

    {
        super.setAccountType(AccountType.STOCK);
    }
}
