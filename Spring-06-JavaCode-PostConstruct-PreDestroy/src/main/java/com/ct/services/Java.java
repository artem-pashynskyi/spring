package com.ct.services;

import com.ct.interfaces.Course;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Java implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Teaching hours : 30");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Executing Post Construct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Executing Pre Destroy");
    }
}
