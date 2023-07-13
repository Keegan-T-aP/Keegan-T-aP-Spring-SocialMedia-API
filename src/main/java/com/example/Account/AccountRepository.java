package com.example.Account;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Account.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    @Query (value = "SELECT * FROM account WHERE username = ?1 AND password = password", nativeQuery = true)
    Account login(String username, String password);

    @Modifying
    @Query (value = "INSERT INTO account (username, password) VALUES (?1, ?2)", nativeQuery = true)
    public void registerAccount(String username, String password);
}
