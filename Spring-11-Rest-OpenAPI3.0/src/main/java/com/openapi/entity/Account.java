package com.openapi.entity;

import com.openapi.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value = {"state", "postal_code"}, ignoreUnknown = true)
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private User user;

    public Account(String name, String address, String country, String state, String city, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }

    public Account(String name, String address, String country, String city, Integer age, UserRole role, User user) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.age = age;
        this.role = role;
        this.user = user;
    }
}
