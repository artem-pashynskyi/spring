package com.cinemaappapi.impl;

import com.cinemaappapi.entity.Account;
import com.cinemaappapi.repository.AccountRepository;
import com.cinemaappapi.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> create(Account account) {
        accountRepository.save(account);
        return findAll();
    }

    @Override
    public List<Account> update(Long id, Account account) {
        account.setId(id);
        accountRepository.save(account);
        return findAll();
    }

    @Override
    public List<Account> delete(Long id) {
        accountRepository.deleteById(id);
        return findAll();
    }
}
