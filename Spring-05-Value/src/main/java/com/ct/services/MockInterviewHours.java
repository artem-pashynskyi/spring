package com.ct.services;

import com.ct.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class MockInterviewHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 10;
    }
}
