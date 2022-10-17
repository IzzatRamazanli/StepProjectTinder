package com.tinder.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll();

    Optional<T> get(int id);

    void save(T entity);


    void delete(int id);

}
