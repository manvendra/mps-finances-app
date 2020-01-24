package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import com.mps.finances.types.BankAccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankAccount extends FinancialAccount {

    private BankAccountType bankAccountType;
    BigDecimal currentBalance;

    public BankAccount(String bankName, String description){

        super(bankName,description,AccountType.BANK);
    }


}
