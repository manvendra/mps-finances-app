package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.types.CreditCardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("CREDIT")
public class CreditCardAccount extends FinancialAccount {

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    private BigDecimal     creditLimit;
    private BigDecimal     currentBalance;
    private BigDecimal     statementBalance;
    private int            billGenerationDayOfMonth;
    private int            daysBetweenBillAndDueDate;
    private String         lastFourDigits;
    private String         registeredAt;

}
