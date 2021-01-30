package com.restlab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restlab.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.web.JsonPath;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public Integer consumeTemp(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String BASE_URL = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";
        Object currentWeather = restTemplate.getForObject(BASE_URL + city, Object.class);
        Map<String, Object> getWeather = (Map<String, Object>) currentWeather;
        Map<String, Object> getTemperature = (Map<String, Object>) getWeather.get("current");
        return Integer.parseInt(getTemperature.get("temperature").toString());
    }
}
