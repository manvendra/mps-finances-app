package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import com.mps.finances.types.CreditCardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class CreditCardAccount extends FinancialAccount {


    private Long id;

    private CreditCardType creditCardType;
    private BigDecimal     limit;
    private BigDecimal     currentBalance;
    private BigDecimal     statementBalance;
    private int            billGenerationDayOfMonth;
    private int            daysBetweenBillAndDueDate;
    private String         lastFourDigits;
    private String         registeredAt;

    public CreditCardAccount(String creditCardCompanyName, String description) {
        super(creditCardCompanyName, description, AccountType.CREDIT_CARD);
    }
}
