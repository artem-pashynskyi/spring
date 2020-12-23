package com.derivedquery;

import com.derivedquery.repository.DepartmentRepository;
import com.derivedquery.repository.EmployeeRepository;
import com.derivedquery.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class Spring09OrmDerivedQueriesApplication {

	@Autowired
	RegionRepository regionRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring09OrmDerivedQueriesApplication.class, args);
	}

	@PostConstruct
	public void test() {
		System.out.println("----------Regions start----------");
		System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
		System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
		System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
		System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
		System.out.println("findTop1ByCountry: " + regionRepository.findTop1ByCountry("Canada"));
		System.out.println("----------Regions end----------");

		System.out.println("----------Departments start----------");
		System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
		System.out.println("findByDivision: " + departmentRepository.findByDivision("Health"));
		System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Health"));
		System.out.println("findByDivisionEquals: " + departmentRepository.findByDivisionEquals("Health"));
		System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
		System.out.println("findDistinctTop3ByDivisionContaining: " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
		System.out.println("----------Departments end----------");

		System.out.println("----------Employees start----------");
		System.out.println("findByEmail: " + employeeRepository.findByEmail("acurwood6@1und1.de"));
		System.out.println("findByFirstNameAndLastNameOrEmail: " + employeeRepository.findByFirstNameAndLastNameOrEmail("Ardeen", "Curwood", "acurwood6@1und1.de"));
//		System.out.println("findByFirstNameIsNot: " + employeeRepository.findByFirstNameIsNot("Ardeen"));
		System.out.println("findByLastNameStartingWith: " + employeeRepository.findByLastNameStartingWith("Curwoo"));
		System.out.println("findBySalaryGreaterThan: " + employeeRepository.findBySalaryGreaterThan(100000));
		System.out.println("findBySalaryLessThan: " + employeeRepository.findBySalaryLessThan(100000));
//		System.out.println("findByHireDateBetween: " + employeeRepository.findByHireDateBetween(LocalDate.now().minusYears(10), LocalDate.now().minusYears(5)));
//		System.out.println("findBySalaryGreaterThanEqualOrderBySalaryDesc: " + employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(100000));
		System.out.println("findDistinctTop3BySalaryLessThan: " + employeeRepository.findDistinctTop3BySalaryLessThan(100000));
		System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());
		System.out.println("----------Employees end----------");
	}
}
