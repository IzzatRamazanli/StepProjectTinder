package com.tinder.services;

import com.tinder.dao.repositories.MessagesDao;
import com.tinder.models.Message;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
public class MessageService {
    private final MessagesDao messagesDao;

    public List<Message> getAllMessages() {
        return messagesDao.getAll();
    }

    public List<Message> getAllMessagesByUser(int sender, int receiver) {
        Predicate<Message> predicate = message ->
                (message.getSender() == sender && message.getReceiver() == receiver)
                        || message.getReceiver() == receiver && message.getSender() == sender;

        return messagesDao.getBy(predicate);
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
