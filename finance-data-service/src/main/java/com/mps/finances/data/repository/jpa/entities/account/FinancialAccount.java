package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.data.repository.jpa.entities.Person;
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

    private String financialInstitutionName;
    private String description;

    @JoinColumn(name = "OWNER_ID", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Person.class,optional = false)
    private Person owner;

    @Column(name = "OWNER_ID")
    private Long ownerId;
}
