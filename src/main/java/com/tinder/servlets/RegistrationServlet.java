package com.tinder.servlets;

import com.tinder.services.RegistrationService;
import com.tinder.enums.RegistrationMessageEnum;
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
public class RegistrationServlet extends HttpServlet {
    //    http://localhost:8080/register
    private final TemplateEngine engine = new TemplateEngine(this);
    private final RegistrationService service;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        engine.render("registration.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConf = req.getParameter("passwordConf");
        String url = req.getParameter("url");

        String msg = service.registerUser(email, password, passwordConf, firstname, lastname, Integer.parseInt(age), url);
        if (msg.equals(RegistrationMessageEnum.SUCCESS.getMessage())) {

            resp.sendRedirect("/login");
        } else {
            data.put("message", msg);
            engine.render("registration.ftl", data, resp);
        }
    }
}
