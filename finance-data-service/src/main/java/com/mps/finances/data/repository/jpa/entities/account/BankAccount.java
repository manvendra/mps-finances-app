package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.types.AccountType;
import com.mps.finances.types.BankAccountType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class BankAccount extends FinancialAccount {

    @Id
    @GeneratedValue
    Long id;
    BigDecimal currentBalance;
    @Enumerated(EnumType.STRING)
    private BankAccountType bankAccountType;
    {
        setAccountType(AccountType.BANK);
    }
}
