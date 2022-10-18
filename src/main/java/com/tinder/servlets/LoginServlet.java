package com.tinder.servlets;

import com.tinder.models.User;
import com.tinder.services.LoginService;
import com.tinder.utils.SessionRelated;
import com.tinder.utils.TemplateEngine;
import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RequiredArgsConstructor
public class LoginServlet extends HttpServlet {
//    http://localhost:8080/login

    private final TemplateEngine engine = new TemplateEngine(this);
    private final LoginService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        engine.render("login.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = service.getUser(req.getParameter("email"), req.getParameter("password"));
        if (user != null) {
            Cookie cookie = SessionRelated.newRandom();
            resp.addCookie(cookie);
            resp.sendRedirect("/like");
        }
    }
}