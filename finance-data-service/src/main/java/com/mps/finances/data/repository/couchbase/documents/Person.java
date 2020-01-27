package com.mps.finances.data.repository.couchbase.documents;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    Long   id;
    String firstName;
    String LastName;

    String phoneNumber;
    String emailAddress;
}
