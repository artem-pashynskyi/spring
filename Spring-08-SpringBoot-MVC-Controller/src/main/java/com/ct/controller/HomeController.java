package com.ct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String getRequestMapping2() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/main")
    public String getRequestMapping3() {
        return "home";
    }

    @GetMapping("/spring")
    public String getMappingExample() {
        return "home";
    }

    @PostMapping("/spring")
    public String postMappingExample() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableExample(@PathVariable("name") String name) {
        System.out.println("Name is: " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableExample(@PathVariable("name") String name, @PathVariable("email") String email) {
        System.out.println("Name is: " + name);
        System.out.println("Email is: " + email);
        return "home";
    }

    @GetMapping("/home/course")
    public String requesParamExample(@RequestParam("course") String course) {
        System.out.println("Course is: " + course);
        return "home";
    }

    @GetMapping("home/course2")
    public String requesParamExample2(@RequestParam(value = "course2", required = false, defaultValue = "Artem") String name) {
        System.out.println("Name is: " + name);
        return "home";
    }

}
