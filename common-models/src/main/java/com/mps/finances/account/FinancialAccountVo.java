package com.mps.finances.account;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mps.finances.PersonVo;
import com.mps.finances.types.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "accountType")
@JsonSubTypes({@JsonSubTypes.Type(value = BankAccountVo.class, name = "BANK"),
               @JsonSubTypes.Type(value = StocksToSellVo.class, name = "STOCK"),
               @JsonSubTypes.Type(value = CreditCardAccountVo.class, name = "CREDIT")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class FinancialAccountVo {

    private String      financialInstitutionName;
    private String      description;
    private AccountType accountType;
    private LocalDate   accountOpenDate;

    private PersonVo owner;
}
