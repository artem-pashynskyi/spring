package com.ct.controller;

import com.ct.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("mentor", new Mentor());
        List<String> batchList = Arrays.asList("B1", "B2", "B3", "E1", "E2", "E3");
        model.addAttribute("batchList", batchList);
        return "mentor/mentorRegister";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor) {
        System.out.println(mentor.toString());
        return "mentor/mentor-confirmation";
    }

}
