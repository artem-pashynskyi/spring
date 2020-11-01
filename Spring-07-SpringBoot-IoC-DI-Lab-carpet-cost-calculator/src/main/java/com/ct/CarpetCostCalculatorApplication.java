package com.ct;

import com.ct.calculator.Calculator;
import com.ct.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarpetCostCalculatorApplication {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(CarpetCostCalculatorApplication.class, args);
		Calculator calculator = container.getBean("calculator", Calculator.class);
		System.out.println(calculator.getTotalCarpetCost(City.ARLINGTON));
	}

}
