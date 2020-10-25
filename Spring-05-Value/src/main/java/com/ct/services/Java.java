package com.ct.services;

import com.ct.interfaces.Course;
import com.ct.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Java implements Course {

    @Value("Hardcoded")
    private String someValue;

    @Value("${name}")
    private String name;

    @Value("${months}")
    private String[] months;

    @Override
    public String toString() {
        return "Java{" +
                "someValue='" + someValue + '\'' +
                ", name='" + name + '\'' +
                ", months=" + Arrays.toString(months) +
                '}';
    }

    @Autowired
    @Qualifier("officeHours")
    private ExtraSessions extraSessions;

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + extraSessions.getHours()));
    }

}
