package com.tinder.servlets;

import com.tinder.utils.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class RootServlet extends HttpServlet {
    TemplateEngine engine = new TemplateEngine(this);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        resp.sendRedirect("/login");
    }
}
