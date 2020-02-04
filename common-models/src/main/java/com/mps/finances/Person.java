package com.mps.finances;

import com.google.i18n.phonenumbers.Phonenumber;
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
    private String LastName;

    private Phonenumber.PhoneNumber phoneNumber;
    private String                  emailAddress;

    private List<FinancialAccount> financialAccounts;
}
