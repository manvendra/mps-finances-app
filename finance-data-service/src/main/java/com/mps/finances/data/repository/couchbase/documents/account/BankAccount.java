package com.mps.finances.data.repository.couchbase.documents.account;

import com.mps.finances.types.AccountType;
import com.mps.finances.types.BankAccountType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class BankAccount extends FinancialAccount {


    Long       id;
    BigDecimal currentBalance;
    @Enumerated(EnumType.STRING)
    private BankAccountType bankAccountType;
    {
        setAccountType(AccountType.BANK);
    }
}
