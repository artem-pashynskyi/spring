package com.cinemaapp;

import com.cinemaapp.repository.MovieCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring09OrmCinemaLabApplication {

	@Autowired
	MovieCinemaRepository movieCinemaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring09OrmCinemaLabApplication.class, args);
	}

	@PostConstruct
	public void test() {
		System.out.println("retrieveAllByLocationCountry: " + movieCinemaRepository.retrieveAllByLocationCountry("United States"));
	}

}
