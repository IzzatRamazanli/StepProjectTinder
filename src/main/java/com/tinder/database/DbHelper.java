package com.tinder.database;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private static final String url = "jdbc:postgresql://localhost:5432/tinder";
    private static final String user = "postgres";
    private static final String password = "root";

    @SneakyThrows
    public Connection connection() {
        return DriverManager.getConnection(url, user, password);
    }

    @SneakyThrows
    public Connection connectionFromUrl(String jdbc_url){
        return DriverManager.getConnection(jdbc_url);
    }

    public void showErrorMessage(SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        System.out.println("Error code: " + ex.getErrorCode());
    }
}
