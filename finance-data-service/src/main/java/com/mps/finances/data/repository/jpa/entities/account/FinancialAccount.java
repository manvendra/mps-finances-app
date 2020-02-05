package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.data.repository.jpa.entities.Person;
import com.mps.finances.types.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE")
public abstract class FinancialAccount {

    @Id
    @GeneratedValue
    Long id;

    private String      financialInstitutionName;
    private String      description;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private Person owner;

}
