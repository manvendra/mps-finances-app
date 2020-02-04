package com.mps.finances.data.repository.jpa.entities.account;


import com.mps.finances.types.BankAccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("BANK")
public class BankAccount extends FinancialAccount {


    BigDecimal currentBalance;

}
