package com.tinder.database;

import com.tinder.model.Like;
import com.tinder.model.Message;
import com.tinder.model.User;
import lombok.Getter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Getter
public class Database {
    private List<User> users = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
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
        this.users.addAll(users);
        return users;
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
        this.likes.addAll(likes);
        return likes;
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
        this.messages.addAll(messages);
        return messages;
    }


}
