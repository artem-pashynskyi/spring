package com.myapp.controller;

import com.myapp.enums.State;
import com.myapp.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("states", Arrays.stream(State.values()).map(Enum::name).collect(Collectors.toList()));
        return "employee/employee-registration";
    }

    @PostMapping("/list")
    public String showEmployees(@ModelAttribute("employee") Employee employee) {
        return "employee/employee-list";
    }

}
