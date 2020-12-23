package com.derivedquery.repository;

import com.derivedquery.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address
    List<Employee> findByEmail(String email);

    //Display all employees with first name and last name, also show all with email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that fist name is not 'Ardeen'
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with 'Curwoo'
    List<Employee> findByLastNameStartingWith(String something);

    //Display all employees with salaries higher that '100000'
    List<Employee> findBySalaryGreaterThan(int salary);

    //Display all employees with salaries less that '100000'
    List<Employee> findBySalaryLessThan(int salary);

    //Display all employees that have been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater or equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(int salary);

    //Display top 3 unique employees that making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(int salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

}
