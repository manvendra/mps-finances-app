package com.mps.finances.data.repository.jpa.entities.account;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("BANK")
public class BankAccount extends FinancialAccount {
    BigDecimal currentBalance;
}
