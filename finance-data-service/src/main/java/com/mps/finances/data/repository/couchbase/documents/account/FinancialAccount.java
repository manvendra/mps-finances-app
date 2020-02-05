package com.mps.finances.data.repository.couchbase.documents.account;



import com.mps.finances.types.AccountType;
import lombok.Data;

@Data
public abstract class FinancialAccount {

    private String financialInstitutionName;
    private String description;

    private AccountType accountType;

}
