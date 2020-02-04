package com.mps.finances.account;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mps.finances.Person;
import com.mps.finances.types.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "accountType")
@JsonSubTypes({@JsonSubTypes.Type(value = BankAccount.class, name = "BANK"), @JsonSubTypes.Type(value = StocksToSell.class, name = "STOCK"), @JsonSubTypes.Type(value = CreditCardAccount.class, name = "CREDIT")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class FinancialAccount {
    private String      financialInstitutionName;
    private String      description;
    private AccountType accountType;
    private Person      owner;
}
