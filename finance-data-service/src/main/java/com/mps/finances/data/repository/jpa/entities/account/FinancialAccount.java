package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.data.repository.jpa.entities.Person;
import com.mps.finances.types.AccountType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class FinancialAccount {

    private String financialInstitutionName;
    private String description;

    @ManyToOne
    private Person person;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
