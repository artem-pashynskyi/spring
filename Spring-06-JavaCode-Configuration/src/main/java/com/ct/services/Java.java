package com.ct.services;

import com.ct.interfaces.Course;
import com.ct.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

public class Java implements Course {

    private ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours " + (30 + extraSessions.getHours()));
    }

    @Value("HardCoded")
    private String word;

    @Value("${name}")
    private String name;

    @Value("${months}")
    private String[] months;

    @Override
    public String toString() {
        return "Java{" +
                "word='" + word + '\'' +
                ", name='" + name + '\'' +
                ", months=" + Arrays.toString(months) +
                '}';
    }

}
