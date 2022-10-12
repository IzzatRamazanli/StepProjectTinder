package com.tinder.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    T get(int id);

    void save(T entity);

    void update(T entity);

    void delete(int id);

}
