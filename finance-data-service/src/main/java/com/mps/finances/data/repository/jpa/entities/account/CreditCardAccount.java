package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.types.AccountType;
import com.mps.finances.types.CreditCardType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class CreditCardAccount extends FinancialAccount {

    @Id
    @GeneratedValue
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
