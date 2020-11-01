package com.ct.calculator;

import com.ct.enums.City;
import com.ct.interfaces.carpetPrices.Carpet;
import com.ct.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Autowired
    @Qualifier("carpetVA")
    private Carpet carpet;

    @Autowired
    @Qualifier("kitchen")
    private Floor floor;

    public String getTotalCarpetCost(City city) {
        BigDecimal cost = carpet.getSqFtPrice(city).multiply(floor.getArea());
        if(cost.compareTo(BigDecimal.ZERO) == 0) {
            try {
                throw new Exception("This City doesn't exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Total Cost for Carpet : " + cost.setScale(2, BigDecimal.ROUND_UP);
    }


}
