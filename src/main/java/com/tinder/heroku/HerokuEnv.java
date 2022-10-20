package com.tinder.heroku;

public class HerokuEnv {
    public static int port() {
        try {
            return Integer.parseInt(System.getenv("PORT"));
        } catch (NumberFormatException ex) {
            return 5000;
        }
    }

    public static String jdbc_url() {
        return "jdbc:postgresql://localhost:5432/tinder";

    }

    public static String jdbc_username() {
        return "postgres";
    }

    public static String jdbc_password() {
        return "root";
    }
}
