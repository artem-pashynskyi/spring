package com.ct.controller;

import com.ct.datagenerator.DataGenerator;
import com.ct.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String employeeCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getStateList());
        return "employee/employee-create";
    }

    @PostMapping("/list")
    public String employeeList(Employee employee, Model model) {
        model.addAttribute("employeeList", Arrays.asList(employee));
        model.addAttribute("age", LocalDate.now().getYear() - LocalDate.parse(employee.getBirthday()).getYear());
        return "employee/employee-list";
    }


}
