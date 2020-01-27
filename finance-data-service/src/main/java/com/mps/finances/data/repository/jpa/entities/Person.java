package com.mps.finances.data.repository.jpa.entities;

import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String LastName;


    String phoneNumber;
    String emailAddress;

    @OneToMany
    List<FinancialAccount> financialAccounts;
}
