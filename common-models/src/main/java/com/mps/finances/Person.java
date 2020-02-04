package com.mps.finances;

import com.mps.finances.account.FinancialAccount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Person {
    private Long   id;
    private String userId;
    private String firstName;
    private String lastName;

    private String phone;
    private String email;

    private List<FinancialAccount> financialAccounts;
}
