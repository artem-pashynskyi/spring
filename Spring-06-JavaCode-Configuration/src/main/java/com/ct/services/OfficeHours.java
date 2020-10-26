package com.ct.services;

import com.ct.interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 7;
    }
}
