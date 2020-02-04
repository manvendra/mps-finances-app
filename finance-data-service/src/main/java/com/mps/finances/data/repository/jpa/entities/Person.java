package com.mps.finances.data.repository.jpa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;


    String phone;
    String email;
}
