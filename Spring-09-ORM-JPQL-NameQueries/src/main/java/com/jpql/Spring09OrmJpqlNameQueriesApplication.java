package com.jpql;

import com.jpql.repository.DepartmentRepository;
import com.jpql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring09OrmJpqlNameQueriesApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring09OrmJpqlNameQueriesApplication.class, args);
	}

	@PostConstruct
	public void test() {
		System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());
		System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());
		System.out.println("getEmployeeByEmail: " + employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu").get());
		System.out.println("getEmployeeByEmailAndSalary: " + employeeRepository.getEmployeeByEmailAndSalary("myakovlivf@ucsd.edu", 78141).get());
		System.out.println("getEmployeeBySalary: " + employeeRepository.getEmployeeBySalary(78141));
		System.out.println("getEmployeeByFirstNameOrSalary: " + employeeRepository.getEmployeeByFirstNameOrSalary("Merell", 78141));
		employeeRepository.updateEmployeeJPQL( 4);
		System.out.println("retrieveEmployeeSalaryGreaterThan: " + employeeRepository.retrieveEmployeeSalaryGreaterThan(150041));
		System.out.println("findMyDepartment: " + departmentRepository.findMyDepartment("Home"));
		System.out.println("countAllDepartments: " + departmentRepository.getAllDepartments());
	}

}
