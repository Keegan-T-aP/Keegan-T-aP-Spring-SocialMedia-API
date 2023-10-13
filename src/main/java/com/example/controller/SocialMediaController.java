package com.example.controller;

import java.sql.SQLException;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.service.MessageService;

import java.util.List;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    @Autowired
    AccountService accountService;

    @Autowired
    MessageService messageService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account body) {
        Account acc = accountService.regiserAccount(body);

        if (acc != null) {
            return ResponseEntity.status(200).body(acc);
        }

        return ResponseEntity.status(409).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account body) {
        Account acc = accountService.login(body);

        if (acc != null) {
            return ResponseEntity.status(200).body(acc);
        }

        return ResponseEntity.status(401).body(null);
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> newMessage(@RequestBody Message body) {
        Message msg = messageService.writeMessage(body);

        if (msg != null) {
            return ResponseEntity.status(200).body(msg);
        }


        return ResponseEntity.status(400).body(null);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> allMsg = messageService.getAllMessages();
        return ResponseEntity.status(200).body(allMsg);
    }

    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int message_id) {
        Message msg = messageService.getMessageById(message_id);
        if (msg != null) {
            return ResponseEntity.status(200).body(msg);
        }
        return ResponseEntity.status(200).body(null);
    }

    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessageById(@PathVariable int message_id) {
        Message msg = messageService.deleteMessageById(message_id);

        if (msg != null) {
            return ResponseEntity.status(200).body(1);
        }

        return ResponseEntity.status(200).body(0);
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> updateMessageById(@RequestBody Message message, @PathVariable int message_id) {
        String text = message.getMessage_text();
        Message msg = messageService.updateMessageText(message_id, text);

        if (msg != null) {
           return ResponseEntity.status(200).body(1);
        }

        return ResponseEntity.status(400).body(null);
    }

    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getAllMessagesFromUser(@PathVariable int account_id) {
        List<Message> allMsg = messageService.getAllMessagesFromUser(account_id);
        return ResponseEntity.status(200).body(allMsg);
    }

    public boolean checkAccount(int id) {
        Account account = accountService.getAccountById(id);
        
        if (account == null) {
            return false;
        }

        return account.getUsername() != null &&
            !account.getUsername().isEmpty() &&
            account.getPassword() != null &&
            !account.getPassword().isEmpty() &&
            account.getPassword().length() >= 4;
    }
}
