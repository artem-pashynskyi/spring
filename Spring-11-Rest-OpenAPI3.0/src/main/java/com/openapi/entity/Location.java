package com.openapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value = {"hibernate_lazy_initializer", "id"}, ignoreUnknown = true)
public class Location extends BaseEntity {

    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal latitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal longitude;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;

    public Location(String name, BigDecimal latitude, BigDecimal longitude, String postalCode, String country, String state, String city, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
    }
}
