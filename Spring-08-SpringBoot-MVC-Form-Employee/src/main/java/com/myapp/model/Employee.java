package com.myapp.model;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    public int getAge() {
        return Period.between(LocalDate.parse(this.birthday), LocalDate.now()).getYears();
    }
}
