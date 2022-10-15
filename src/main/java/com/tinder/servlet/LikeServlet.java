package com.tinder.servlet;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");

        HashMap<String, Object> data = new HashMap<>();
        try (PrintWriter writer = resp.getWriter()) {
            configuration.getTemplate("like-page.ftl").process(data, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }


    }
}
