package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Account;
import com.example.repository.AccountRepository;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;
// commit fix
@Service
public class MessageService {
    AccountRepository accountRepository;
    MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository msgRepo, AccountRepository accRepo) {
        messageRepository = msgRepo;
        accountRepository = accRepo;
    }

    public Message writeMessage(Message msg) {
        String text = msg.getMessage_text();
        if (text.length() > 254 || text.equals("")) {
            return null;
        }
        Optional<Account> accOp = this.accountRepository.findById(msg.getPosted_by());
        if (!accOp.isPresent()) {
            return null;
        }
        return msgRepo.save(msg);
    }

    public List<Message> getAllMessages() {
        return msgRepo.findAll();
    }

    public Message getMessageById(int id) {
        Optional<Message> msg = msgRepo.findById(id);
        if (msg.isPresent()) {
            return msg.get();
        }
        return null;
    }

    public Message deleteMessageById(int id) {
        Optional<Message> msg = msgRepo.findById(id);
        if (msg.isPresent()) {
            Message nmsg = msg.get();
            msgRepo.deleteById(id);
            return nmsg;
        }
        return null;
    }

    public Message updateMessageText(int id, String text) {
        if (getMessageById(id) == null) {
            return null;
        }

        if (text.length() > 254 || text.equals("")) {
            return null;
        }

        Optional<Message> message = msgRepo.findById(id);
        if (message.isPresent()) {
            Message msg = message.get();
            msg.setMessage_text(text);
            msgRepo.save(msg);
            return msg;
        }

        return null;
    }

    public List<Message> getAllMessagesFromUser(int id) {
        List<Message> allMessages = msgRepo.findAll();
        List<Message> userMessages = new LinkedList<Message>();

        for (int i = 0; i < allMessages.size(); i++) {
            Message temp = allMessages.get(i);
            if (temp.getPosted_by() == id) {
                userMessages.add(temp);
            }
        }

        return userMessages;
    }
}
