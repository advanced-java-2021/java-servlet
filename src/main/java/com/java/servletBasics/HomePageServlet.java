package com.java.servletBasics;

import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AboutUsPageServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.service(req, resp);
//        System.out.println(this.getClass()+ " service executed");
        LOGGER.info("{}",this.getClass());
        resp.getWriter().write("home page");
        Thread currentThread = Thread.currentThread();
        System.out.println("current thread: "+currentThread);
    }
}
