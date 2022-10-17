package com.tinder.services;

import com.tinder.dao.impl.MessagesDao;
import com.tinder.model.Message;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MessageService {
    private final MessagesDao messagesDao;

    public List<Message> getAllMessages() {
        return messagesDao.getAll();
    }

    public void createNewMessage(Message message) {
        messagesDao.save(message);
    }

    public Message getMessage(int id) {
        return messagesDao.get(id).orElse(null);
    }

    public void deleteMessage(int id) {
        messagesDao.delete(id);
    }
}
