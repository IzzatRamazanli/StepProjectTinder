package com.tinder;

import com.tinder.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TinderApplication {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(TestServlet.class, "/test");
        handler.addServlet(new ServletHolder(LikeServlet.class), "/like");
        handler.addServlet(new ServletHolder(RegistrationServlet.class), "/register");
        handler.addServlet(new ServletHolder(MessagingServlet.class), "/chat");
        handler.addServlet(new ServletHolder(LoginServlet.class), "/login");
        handler.addServlet(new ServletHolder(new StaticFileServlet("src/main/resources/templates")), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
