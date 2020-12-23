package com.derivedquery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Department {

    @Id
    private String department;
    private String division;

}
