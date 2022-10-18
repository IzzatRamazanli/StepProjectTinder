package com.tinder;

import com.tinder.dao.repositories.UserDao;
import com.tinder.database.DbHelper;
import com.tinder.filters.CookieFilter;
import com.tinder.filters.LoginFilter;
import com.tinder.services.LoginService;
import com.tinder.services.RegistrationService;
import com.tinder.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class TinderApplication {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        DbHelper helper = new DbHelper();
        Connection connection = helper.connection();

        EnumSet<DispatcherType> dt = EnumSet.of(DispatcherType.REQUEST);

        //---------------------------Registration and Login-----------------------------------------------//
        UserDao userDao = new UserDao(connection);
        RegistrationService registrationService = new RegistrationService(userDao);
        RegistrationServlet registrationServlet = new RegistrationServlet(registrationService);

        LoginService loginService = new LoginService(userDao);
        LoginServlet loginServlet = new LoginServlet(loginService);
        LoginFilter loginFilter = new LoginFilter(loginService);

        handler.addFilter(CookieFilter.class, "", dt);
        handler.addFilter(CookieFilter.class, "/logout", dt);
        handler.addFilter(new FilterHolder(loginFilter), "/login", dt);

        //--------------------------- Registration and Login -----------------------------------------------//

        handler.addServlet(RootServlet.class, "");
        handler.addServlet(new ServletHolder(registrationServlet), "/register");
        handler.addServlet(new ServletHolder(loginServlet), "/login");
        handler.addServlet(LogoutServlet.class, "/logout");
        handler.addServlet(new ServletHolder(LikeServlet.class), "/like");
        handler.addServlet(new ServletHolder(MessagingServlet.class), "/chat");
        handler.addServlet(new ServletHolder(new StaticFileServlet("src/main/resources/templates")), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
