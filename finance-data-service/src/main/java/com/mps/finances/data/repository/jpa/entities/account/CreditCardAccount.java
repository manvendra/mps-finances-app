package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.types.AccountType;
import com.mps.finances.types.CreditCardType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@DiscriminatorValue("CREDIT_CARD")
public class CreditCardAccount extends FinancialAccount {



    private CreditCardType creditCardType;
    private BigDecimal     cardLimit;
    private BigDecimal     currentBalance;
    private BigDecimal     statementBalance;
    private int            statementGenerationDateOfMonth;
    private int            daysBetweenGenerationAndDueDate;
    private String         lastFourDigits;

}
