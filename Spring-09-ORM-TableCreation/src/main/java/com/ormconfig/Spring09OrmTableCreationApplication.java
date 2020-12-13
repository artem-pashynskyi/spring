package com.ormconfig;

import com.ormconfig.entity.Car;
import com.ormconfig.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Spring09OrmTableCreationApplication {

	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring09OrmTableCreationApplication.class, args);
	}

	@PostConstruct
	public void dataInit() {
		var c1 = new Car("BMW", "M5");
		var c2 = new Car("Honda", "Civic");
		var c3 = new Car("Honda", "Accord");

		carRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
