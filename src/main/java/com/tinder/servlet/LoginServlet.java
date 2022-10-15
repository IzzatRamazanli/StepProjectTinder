package com.tinder.servlet;

import com.tinder.util.TemplateEngine;
import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RequiredArgsConstructor
public class LoginServlet extends HttpServlet {
//    http://localhost:8080/login

    private final TemplateEngine engine = new TemplateEngine(this);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        engine.render("login.ftl", data, resp);
    }
}