package com.example.account;

import com.example.account.AccountRepository;
import com.example.account.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account login(String username, String password) { return accountRepository.login(username, password);}

    public void registerAccount(String username, String password) { accountRepository.registerAccount(username, password);}
}
