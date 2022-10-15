package com.tinder.servlet;

import com.tinder.util.TemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@RequiredArgsConstructor
public class LikeServlet extends HttpServlet {

    private final TemplateEngine engine = new TemplateEngine(this);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, Object> data = new HashMap<>();
        engine.render("like-page.ftl", data, resp);
    }
}
