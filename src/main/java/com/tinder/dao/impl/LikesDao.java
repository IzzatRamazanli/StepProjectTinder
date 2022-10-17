package com.tinder.dao.impl;

import com.tinder.dao.Dao;
import com.tinder.model.Like;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class LikesDao implements Dao<Like> {
    private final Connection connection;

    public LikesDao(Connection connection) {
        this.connection = connection;
    }

    private final String getLikes = "select * from likes";

    private final String getLike = "select * from likes where id = ?";

    private final String insertLike = "insert into likes(from, to, status)" +
            "values(?, ?, ?)";
    private final String deleteLike = "delete from likes where id = ?";

    @Override
    @SneakyThrows
    public List<Like> getAll() {
        List<Like> likes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(getLikes)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Like l = new Like(
                        resultSet.getInt("id"),
                        resultSet.getInt("from"),
                        resultSet.getInt("to"),
                        resultSet.getBoolean("status")
                );
                likes.add(l);
            }
        }
        return likes;
    }

    @Override
    @SneakyThrows
    public Optional<Like> get(int id) {
        try (PreparedStatement statement = connection.prepareStatement(getLike)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return !resultSet.next() ? Optional.empty() : Optional.of(
                    new Like(
                            resultSet.getInt("id"),
                            resultSet.getInt("from"),
                            resultSet.getInt("to"),
                            resultSet.getBoolean("status")
                    ));
        }

    }

    @Override
    public List<Like> getBy(Predicate<Like> predicate) {
        return getAll().stream().filter(predicate).toList();
    }

    @Override
    @SneakyThrows
    public void save(Like entity) {
        try (PreparedStatement statement = connection.prepareStatement(insertLike)) {
            statement.setInt(1, entity.getFrom());
            statement.setInt(2, entity.getTo());
            statement.setBoolean(3, entity.isStatus());
            statement.executeUpdate();
        }
    }

    @Override
    @SneakyThrows
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(deleteLike)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}
