package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.types.CreditCardType;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@Entity
@DiscriminatorValue("CREDIT_CARD")
public class CreditCardAccount extends FinancialAccount {

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    private String         lastFourDigits;

    private BigDecimal cardLimit;
    private BigDecimal currentBalance;
    private BigDecimal statementBalance;

    private int statementGenerationDateOfMonth;
    private int daysBetweenGenerationAndDueDate;

    private String registeredAt;
}
