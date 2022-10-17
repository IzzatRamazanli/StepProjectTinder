package com.tinder.dao.impl;

import com.tinder.dao.Dao;
import com.tinder.model.Like;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class LikesDao implements Dao<Like> {
    @Override
    public List<Like> getAll() {
        return null;
    }

    @Override
    public Optional<Like> get(int id) {
        return null;
    }

    @Override
    public List<Like> getBy(Predicate<Like> predicate) {
        return null;
    }

    @Override
    public void save(Like entity) {

    }

    @Override
    public void delete(int id) {

    }
}
