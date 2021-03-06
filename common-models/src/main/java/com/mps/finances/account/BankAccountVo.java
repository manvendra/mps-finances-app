package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import com.mps.finances.types.BankAccountType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class BankAccountVo extends FinancialAccountVo {

    private Long            id;
    private BigDecimal      currentBalance;
    private BankAccountType bankAccountType;
    {
        super.setAccountType(AccountType.BANK);
    }
}
