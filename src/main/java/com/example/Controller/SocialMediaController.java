package com.example.Controller;

import java.util.ArrayList;


import com.example.Account.AccountService;
import com.example.Message.MessageService;
import org.springframework.web.bind.annotation.*;

import com.example.Account.Account;
import com.example.Message.Message;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

@RestController
public class SocialMediaController {

    private final AccountService accountService;
    private final MessageService messageService;

    SocialMediaController(AccountService accountService, MessageService messageService) {
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public @ResponseBody ArrayList<Message> getAllMessages() {
    return messageService.getAllMessages();
    }

    @GetMapping("/messages/{message_id}")
    public @ResponseBody Message getMessageByID(@PathVariable int message_id) {
        System.out.println("You have reached me!");
    return messageService.getMessageByID(message_id);
    }

    @GetMapping("/accounts/{account_id}/messages")
    ArrayList<Message> getMessageByAccount(@PathVariable int posted_by) {
        return messageService.getMessageByAccount(posted_by);
    }

    @PostMapping("/register")
    void registerAccount(String username, String password) {
    accountService.registerAccount(username, password);
    }

    @PostMapping("/messages")
    void newMessage(int posted_by, String message_text, long time_posted_epoch) {
        messageService.newMessage(posted_by, message_text, time_posted_epoch);
    }

    @GetMapping("/login")
    Account login(String username, String password) {return accountService.login(username, password);}


    @DeleteMapping("/messages/{message_id}")
    void deleteMessage(@PathVariable int message_id) {
    messageService.deleteMessage(message_id);
    }

}
