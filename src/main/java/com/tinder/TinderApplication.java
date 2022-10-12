package com.tinder;

import com.tinder.model.User;
import com.tinder.servlet.TestServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class TinderApplication {
    public static void main(String[] args) throws Exception {
//        Server server = new Server(8080);
//        ServletContextHandler handler = new ServletContextHandler();
//        handler.addServlet(TestServlet.class, "/test");
//        server.setHandler(handler);
//        server.start();
//        server.join();

        User user = new User("ad", "wef", "iz", "we", 0, "sds");
    }
}
