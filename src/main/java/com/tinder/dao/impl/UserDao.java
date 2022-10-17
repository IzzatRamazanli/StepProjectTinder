package com.tinder.dao.impl;

import com.tinder.dao.Dao;
import com.tinder.model.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserDao implements Dao<User> {

    private final Connection connection;

    private final String getAllQuery = "select * from users";
    private final String getQuery = "select * from users where id = ?";
    private final String insertQuery = "insert into users(email, password, firstname, lastname, age, url)" +
            "values(?, ?, ? ,?, ?, ?)";
    private final String deleteQuery = "delete from users where id = ?";

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    @SneakyThrows
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(getAllQuery)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User u = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("url")
                );
                users.add(u);
            }
        }
        return users;
    }

    @Override
    public List<User> getBy(Predicate<User> predicate) {
        return getAll().stream().filter(predicate).toList();
    }

    @Override
    @SneakyThrows
    public Optional<User> get(int id) {

        try (PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next() ? Optional.empty() : Optional.of(
                    new User(
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname"),
                            resultSet.getInt("age"),
                            resultSet.getString("url")
                    )
            );
        }
    }

    @Override
    @SneakyThrows
    public void save(User entity) {
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getFirstname());
            statement.setString(4, entity.getLastname());
            statement.setInt(5, entity.getAge());
            statement.setString(6, entity.getUrl());
            statement.executeUpdate();
        }
    }

    @Override
    @SneakyThrows
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}
