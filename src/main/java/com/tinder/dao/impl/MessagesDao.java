package com.tinder.dao.impl;

import com.tinder.dao.Dao;
import com.tinder.model.Message;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MessagesDao implements Dao<Message> {

    private final Connection connection;

    public MessagesDao(Connection connection) {
        this.connection = connection;
    }

    private final String getMessages = "select * from messages";
    private final String getMessage = " select * from messages where id = ?";
    private final String insertMessage = "insert into messages(sender, receiver, content, send_date)" +
            "values(?, ?, ?, ?)";
    private final String deleteMessage = "delete from messages where id = ?";

    @Override
    @SneakyThrows
    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(getMessages)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Message m = new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("sender"),
                        resultSet.getInt("receiver"),
                        resultSet.getString("content"),
                        resultSet.getString("send_date")
                );
                messages.add(m);
            }
        }
        return messages;
    }

    @Override
    @SneakyThrows
    public Optional<Message> get(int id) {
        try (PreparedStatement statement = connection.prepareStatement(getMessage)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next() ? Optional.empty() : Optional.of(
                    new Message(
                            resultSet.getInt("id"),
                            resultSet.getInt("sender"),
                            resultSet.getInt("receiver"),
                            resultSet.getString("content"),
                            resultSet.getString("send_date")
                    ));
        }
    }

    @Override
    public List<Message> getBy(Predicate<Message> predicate) {
        return getAll().stream().filter(predicate).toList();
    }

    @Override
    @SneakyThrows
    public void save(Message entity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm");
        try (PreparedStatement statement = connection.prepareStatement(insertMessage)) {
            statement.setInt(1, entity.getSender());
            statement.setInt(2, entity.getReceiver());
            statement.setString(3, entity.getContent());
            statement.setString(4, LocalDateTime.now().format(formatter));
            statement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(deleteMessage)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}
