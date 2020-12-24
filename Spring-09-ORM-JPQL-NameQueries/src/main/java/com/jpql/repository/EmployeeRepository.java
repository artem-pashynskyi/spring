package com.jpql.repository;

import com.jpql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    //singe bind parameter
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);

    //multiple bind parameter
    @Query("select e from Employee e where e.email = ?1 and e.salary = ?2")
    Optional<Employee> getEmployeeByEmailAndSalary(String email, int salary);

    //single named parameter
    @Query("select e from Employee e where e.salary = :salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //multiple named parameter
    @Query("select e from Employee e where e.firstName = :name and e.salary = :salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name, @Param("salary") int salary);

    //Not Equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //Like / Contains / Starts With / Ends with
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //Less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    //Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    //Before
    @Query("select e from Employee e where e.hireDate < ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();

    //Sort salary in desc order
    @Query("select e from Employee e where e.salary = ?1 order by e.salary")
    List<Employee> getEmployeeBySalaryOrderBy(int salary);

    //Native Query
    @Query(value = "select * from employees where salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

    @Modifying
    @Transactional
    @Query("update Employee e set e.email = 'admin@gmail.com' where e.id = :id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update employees set email = 'admin@gmail.com' where id = :id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //Named query
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);

}
