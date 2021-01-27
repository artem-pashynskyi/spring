package com.cinemaappapi.controller;

import com.cinemaappapi.entity.Account;
import com.cinemaappapi.services.AccountService;
import com.cinemaappapi.wrapper.AccountResponseWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private HttpHeaders httpHeaders;
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
        httpHeaders = new HttpHeaders();
        httpHeaders.set("Version", "cinemaApp-v1");
    }

    @GetMapping
    public ResponseEntity<AccountResponseWrapper> readAllAccounts() {
        httpHeaders.set("Operation", "find-all");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new AccountResponseWrapper("Accounts have been successfully retrieved!",
                        accountService.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Account::getId))
                        .collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseWrapper> readAccount(@PathVariable("id") Long id) {
        httpHeaders.set("Operation", "find-by-id");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new AccountResponseWrapper("Account has been successfully retrieved!",
                        accountService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<AccountResponseWrapper> createAccount(@RequestBody Account account) {
        httpHeaders.set("Operation", "create");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new AccountResponseWrapper("Account has been successfully created!",
                        accountService.create(account)
                        .stream()
                        .sorted(Comparator.comparing(Account::getId))
                        .collect(Collectors.toList())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseWrapper> updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        httpHeaders.set("Operation", "update");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new AccountResponseWrapper("Account has been successfully updated!",
                        accountService.update(id, account)
                        .stream()
                        .sorted(Comparator.comparing(Account::getId))
                        .collect(Collectors.toList())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountResponseWrapper> deleteAccount(@PathVariable("id") Long id) {
        httpHeaders.set("Operation", "delete");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new AccountResponseWrapper("Account has been successfully deleted!",
                        accountService.delete(id)
                                .stream()
                                .sorted(Comparator.comparing(Account::getId))
                                .collect(Collectors.toList())));
    }

}
