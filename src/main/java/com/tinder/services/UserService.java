package com.tinder.services;

import com.tinder.dao.repositories.UserDao;
import com.tinder.models.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserService {
    private final UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getUser(int id) {
        return userDao.get(id).orElse(null);
    }

    public void insertUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }
}
