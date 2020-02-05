package com.mps.finances.account;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.mps.finances.types.AccountType;
import com.mps.finances.types.CreditCardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class CreditCardAccountVo extends FinancialAccountVo {


    private Long id;

    private CreditCardType creditCardType;
    private BigDecimal     limit;
    private BigDecimal     currentBalance;
    private BigDecimal     statementBalance;
    private int            billGenerationDayOfMonth;
    private int            daysBetweenBillAndDueDate;
    private String         lastFourDigits;
    private String         registeredAt;

    {
        super.setAccountType(AccountType.CREDIT_CARD);
    }
}