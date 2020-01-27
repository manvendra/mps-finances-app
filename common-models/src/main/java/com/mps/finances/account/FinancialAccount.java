package com.mps.finances.account;


import com.mps.finances.types.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class FinancialAccount {

    private String      financialInstitutionName;
    private String      description;
    private AccountType accountType;
}
