package com.tinder.servlets;

import com.tinder.utils.SessionRelated;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = SessionRelated.findOrDie(req);

        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        try (PrintWriter writer = resp.getWriter()) {
            String message = String.format("user %s successfully logged out", cookie.getValue());
            writer.println(message);
        }
    }
}
