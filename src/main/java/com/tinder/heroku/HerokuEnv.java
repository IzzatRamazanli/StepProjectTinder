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
        String url = System.getenv("jdbc:postgresql://localhost:5432/tinder");
        if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_URL is empty!!!");
        return url;
    }

    public static String jdbc_username() {
        String url = System.getenv("postgres");
        if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_USERNAME is empty!!!");
        return url;
    }

    public static String jdbc_password() {
        String url = System.getenv("root");
        if (url == null) throw new IllegalArgumentException("JDBC_DATABASE_PASSWORD is empty!!!");
        return url;
    }
}
