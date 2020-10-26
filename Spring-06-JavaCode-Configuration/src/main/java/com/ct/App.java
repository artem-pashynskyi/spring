package com.ct;

import com.ct.configs.AppConfig;
import com.ct.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();
        System.out.println(course.toString());
    }

}
