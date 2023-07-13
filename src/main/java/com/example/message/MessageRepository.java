package com.example.message;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.message.Message;

import java.util.ArrayList;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

    @Modifying
    @Query (value = "INSERT INTO message (posted_by, message_text, time_posted_epoch) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public void newMessage(int posted_by, String message_text, long time_posted_epoch);

    @Query (value = "SELECT * FROM message", nativeQuery = true)
    ArrayList<Message> getAllMessages();

    @Query (value = "SELECT * FROM message WHERE message_id = ?1", nativeQuery = true)
    Message getMessageByID(int message_id);

    @Query (value = "SELECT * FROM message WHERE posted_by = ?1", nativeQuery = true)
    ArrayList<Message> getMessageByAccount(int posted_by);

    @Modifying
    @Query (value = "UPDATE message SET message_text = ?1, WHERE message_id = ?2", nativeQuery = true)
    void updateMessage(String message_text, int message_id);

    @Modifying
    @Query (value = "DELETE FROM message WHERE message_id = ?1", nativeQuery = true)
    void deleteMessage(int message_id);
}
