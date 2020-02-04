package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import com.mps.finances.types.BankAccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class BankAccount extends FinancialAccount {

    private Long            id;
    private BigDecimal      currentBalance;
    private BankAccountType bankAccountType;


    public BankAccount(String bankName, String description) {
        super(bankName, description, AccountType.BANK);
    }
}
