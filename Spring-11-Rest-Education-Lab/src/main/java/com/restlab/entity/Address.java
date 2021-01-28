package com.restlab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restlab.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "teacher"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity {
    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;
    @OneToOne(mappedBy = "address")
    private Teacher teacher;
    private Integer currentTemperature;

    private Integer getCurrentTemperature() {
        return consumeTemp(this.city);
    }

    private Integer consumeTemp(String city) {
        return 5;
    }
}
