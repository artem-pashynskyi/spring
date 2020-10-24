package com.ct.services;

import com.ct.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //Field Injection
    @Autowired
    private OfficeHours officeHours;

    //Constructor Injection
//    @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    //Setter Injection
//    @Autowired
//    public void setOfficeHours(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + officeHours.getHours()));
    }

}
