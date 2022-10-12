package com.tinder.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private static final String url = "jdbc:mysql://localhost:3306/tinder";
    private static final String user = "root";
    private static final String password = "root";

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void showErrorMessage(SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        System.out.println("Error code: " + ex.getErrorCode());
    }
}
