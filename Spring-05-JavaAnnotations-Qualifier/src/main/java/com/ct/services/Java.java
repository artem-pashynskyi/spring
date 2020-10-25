package com.ct.services;

import com.ct.interfaces.Course;
import com.ct.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Autowired
    @Qualifier("mockInterviewHours")
    private ExtraSessions extraSessions;

    //Qualifier in Constructor
//    @Autowired
//    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
//        this.extraSessions = extraSessions;
//    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + extraSessions.getHours()));
    }

}
