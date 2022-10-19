package com.tinder.servlets;

import com.tinder.models.User;
import com.tinder.services.LikeService;
import com.tinder.utils.TemplateEngine;
import com.tinder.utils.UserTracker;
import lombok.RequiredArgsConstructor;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class LikeServlet extends HttpServlet {
//    http://localhost:8080/like

    private final TemplateEngine engine = new TemplateEngine(this);
    private final LikeService likeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        List<User> likedUser = likeService.getLikedUser(UserTracker.getUser().getId());
        data.put("users", likedUser);
        engine.render("people-list.ftl", data, resp);
    }
}
