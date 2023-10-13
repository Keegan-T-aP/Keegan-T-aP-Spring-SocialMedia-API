package com.example.service;

import com.example.repository.AccountRepository;
import com.example.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    AccountRepository accRepo;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        accRepo = accountRepository;
    }

    public Account regiserAccount(Account acc) {
        boolean makeAcc = true;
        if (getAccountByName(acc)) {
            makeAcc = false;
        }

        if (acc.getPassword().length() < 4) {
            makeAcc = false;
        }

        if (makeAcc) {
            return accRepo.save(acc);
        }
        return null;
    }

    public boolean getAccountByName(Account acc) {
        List<Account> oppAcc = accRepo.findAll();
        String name = acc.getUsername();
        for (Account account : oppAcc) {
            if (account.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Account getAccountById(int id) {
        Optional<Account> acc = accRepo.findById(id);
        if (acc.isPresent()) {
            return acc.get();
        }
        return null;
    }

    public Account login(Account acc) {
        List<Account> oppAcc = accRepo.findAll();
        String name = acc.getUsername();
        String pass = acc.getPassword();
        for (Account account : oppAcc) {
            if (account.getUsername().equals(name)
             && account.getPassword().equals(pass)) {
                return account;
            }
        }
        return null;
    }
}
