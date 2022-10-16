package com.tinder.database;

import com.tinder.model.Like;
import com.tinder.model.Message;
import com.tinder.model.User;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Getter
public class Database {

    private final DbHelper helper = new DbHelper();

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        ResultSet set;
        try (Connection connection = helper.connection(); Statement statement = connection.createStatement()) {
            set = statement.executeQuery("SELECT * FROM tinder.user;");
            while (set.next()) {
                users.add(new User(set.getInt("id"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("firstname"),
                        set.getString("lastname"),
                        set.getInt("age"),
                        set.getString("pictureUrl")));
            }
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return users;
    }

    public void saveUser(User user) {
        String query = "insert into tinder.user (firstname, lastname, age, email, password, pictureUrl) values(?,?,?,?,?,?)";
        try (Connection connection = helper.connection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getPictureUrl());
            statement.executeUpdate();
            System.out.println("Record added");
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }

    }

    public User getUser(int id) {
        String query = "select * from users where id = ?";
        try (Connection conn = helper.connection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int uid = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                String url = resultSet.getString("url");
                return new User(uid, email, password, firstname, lastname, age, url);
            }

        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return new User();
    }

    public List<User> getLikedUser(int id) {
        List<User> likedUsers = new ArrayList<>();
        String query = "select * from tinder.user where id in(select to from likes where from = ? and status = true)";
        try (Connection conn = helper.connection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            likedUsers.add(new User(set.getInt("id"),
                    set.getString("email"),
                    set.getString("password"),
                    set.getString("firstname"),
                    set.getString("lastname"),
                    set.getInt("age"),
                    set.getString("pictureUrl")));
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return likedUsers;
    }

    public List<Like> getAllLikes() {
        List<Like> likes = new ArrayList<>();
        ResultSet set;
        try (Connection connection = helper.connection(); Statement statement = connection.createStatement()) {
            set = statement.executeQuery("SELECT * FROM tinder.like;");
            while (set.next()) {
                likes.add(new Like(set.getInt("id"),
                        set.getInt("from"),
                        set.getInt("to"),
                        set.getBoolean("status")));
            }
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return likes;
    }

    public void saveLike(Like like) {
        String query = "insert into tinder.like (from, to, status) values (?, ?, ?)";
        try (Connection conn = helper.connection(); PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, like.getFrom());
            statement.setInt(2, like.getTo());
            statement.setBoolean(3, like.isStatus());
            statement.executeUpdate();
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
    }

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        ResultSet set;
        try (Connection connection = helper.connection(); Statement statement = connection.createStatement()) {
            set = statement.executeQuery("SELECT * FROM tinder.message;");
            while (set.next()) {
                messages.add(new Message(set.getInt("id"),
                        set.getInt("sender"),
                        set.getInt("receiver"),
                        set.getString("content"),
                        set.getString("sendDate")));
            }
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return messages;
    }


}
