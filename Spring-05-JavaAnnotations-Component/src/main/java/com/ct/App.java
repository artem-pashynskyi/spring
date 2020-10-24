package com.ct;

import com.ct.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("API", Course.class);

        course.getTeachingHours();

    }

}
