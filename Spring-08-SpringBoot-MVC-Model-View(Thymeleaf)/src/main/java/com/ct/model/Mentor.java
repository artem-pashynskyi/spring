package com.ct.model;

import com.ct.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mentor {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
}
