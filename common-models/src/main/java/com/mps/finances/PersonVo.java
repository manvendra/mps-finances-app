package com.mps.finances;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.mps.finances.account.FinancialAccountVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonRootName("person")
public class PersonVo {
    private Long   id;

    private String firstName;
    private String lastName;

    private String phone;
    private String email;

    private List<FinancialAccountVo> financialAccounts;
}
