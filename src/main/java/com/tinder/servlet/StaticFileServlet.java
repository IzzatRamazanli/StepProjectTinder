package com.tinder.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class StaticFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedName = req.getPathInfo();
        if (requestedName.startsWith("/")) requestedName = requestedName.substring(1);

        URI fileUri;
        try {
            fileUri = Objects.requireNonNull(getClass().getClassLoader().getResource(requestedName)).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            Files.copy(Path.of(fileUri), outputStream);
        }
    }
}
