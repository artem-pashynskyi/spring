package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentData")
    List<Student> getStudent() {
        return studentService.getStudentData();
    }

    @GetMapping("/student")
    Student getStudentService() {
        return new Student("mike", "smith", 20);
    }
}
