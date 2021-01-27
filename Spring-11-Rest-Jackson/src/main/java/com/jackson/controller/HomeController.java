package com.jackson.controller;

import com.jackson.entity.Account;
import com.jackson.entity.Cinema;
import com.jackson.entity.User;
import com.jackson.repository.AccountRepository;
import com.jackson.repository.CinemaRepository;
import com.jackson.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private HttpHeaders responseHttpHeaders;
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private CinemaRepository cinemaRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository, CinemaRepository cinemaRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "cinemaApp-v2");
        responseHttpHeaders.set("Operation", "read-all");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> readAllUsers() {
        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(userRepository.findAll());
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> readAllAccounts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(responseHttpHeaders)
                .body(accountRepository.findAll());
    }

    @GetMapping("/cinemas")
    public List<Cinema> readAllCinemas() {
        return cinemaRepository.findAll();
    }
}
