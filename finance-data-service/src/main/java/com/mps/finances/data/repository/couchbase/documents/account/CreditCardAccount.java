package com.mps.finances.data.repository.couchbase.documents.account;


import com.mps.finances.types.AccountType;
import com.mps.finances.types.CreditCardType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCardAccount extends FinancialAccount {


    Long id;

    private CreditCardType creditCardType;
    private BigDecimal     cardLimit;
    private BigDecimal     currentBalance;
    private BigDecimal     statementBalance;
    private int            statementGenerationDateOfMonth;
    private int            daysBetweenGenerationAndDueDate;
    private String         lastFourDigits;
    {
        setAccountType(AccountType.CREDIT_CARD);
    }
}
