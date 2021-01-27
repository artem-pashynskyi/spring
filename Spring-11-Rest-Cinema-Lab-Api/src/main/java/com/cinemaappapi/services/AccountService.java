package com.cinemaappapi.services;

import com.cinemaappapi.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(Long id);
    List<Account> create(Account account);
    List<Account> update(Long id, Account account);
    List<Account> delete(Long id);
}
