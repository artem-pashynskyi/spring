package com.ct.interfaces.carpetPrices;

import com.ct.enums.City;

import java.math.BigDecimal;

public interface Carpet {
    BigDecimal getSqFtPrice(City city);
}
