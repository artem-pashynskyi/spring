package com.ct.services;

import com.ct.interfaces.Course;

public class Java implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 20");
    }
}
