package com.tinder.dao.impl;

import com.tinder.dao.Dao;
import com.tinder.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MessagesDao implements Dao<Message> {
    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public Optional<Message> get(int id) {
        return null;
    }

    @Override
    public List<Message> getBy(Predicate<Message> predicate) {
        return null;
    }

    @Override
    public void save(Message entity) {

    }


    @Override
    public void delete(int id) {

    }
}
