package com.ct.services;

import com.ct.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class API implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 40");
    }
}
