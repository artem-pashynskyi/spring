package com.ormconfig.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Transient
    private String password;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;

}
