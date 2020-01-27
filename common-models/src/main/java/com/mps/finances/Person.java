package com.mps.finances;

import com.google.i18n.phonenumbers.Phonenumber;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    Long   id;
    String firstName;
    String LastName;

    Phonenumber.PhoneNumber phoneNumber;
    String                  emailAddress;
}
