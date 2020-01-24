package com.mps.finances.account;

import com.mps.finances.types.AccountType;
import com.mps.finances.types.CreditCardType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;

@Getter
@Setter
public class CreditCardAccount extends FinancialAccount {

    private CreditCardType creditCardType;
    private BigDecimal cardLimit;
    private BigDecimal currentBalance;
    private BigDecimal statementBalance;
    private int statementGenerationDateOfMonth;
    private int daysBetweenGenerationAndDueDate;
    private String lastFourDigits;


    public CreditCardAccount(String creditCardCompanyName,String description){
        super(creditCardCompanyName,description, AccountType.CREDIT_CARD);


    }

}
