package com.example.Service;

import com.example.Repository.AccountRepository;
import com.example.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account login(String username, String password) { return accountRepository.login(username, password);}

    public void registerAccount(String username, String password) { accountRepository.registerAccount(username, password);}
}
