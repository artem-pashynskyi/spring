package com.ct.services;

import com.ct.interfaces.Course;

public class Java implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 20");
    }

    public void myInitMethod() {
        System.out.println("Executing Init Method");
    }

    public void myDestroyMethod() {
        System.out.println("Executing Destroy Method");
    }
}
