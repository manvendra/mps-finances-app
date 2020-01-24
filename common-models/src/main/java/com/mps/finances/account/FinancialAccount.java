package com.mps.finances.account;


import com.mps.finances.types.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public abstract class FinancialAccount {

    private final String      financialInstitutionName;
    private final String      description;
    private final AccountType accountType;
}
