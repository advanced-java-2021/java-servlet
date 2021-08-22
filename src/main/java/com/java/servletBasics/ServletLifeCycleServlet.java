package com.java.servletBasics;

import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLifeCycleServlet extends HttpServlet {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ServletLifeCycleServlet.class);
    // one time
    @Override
    public void init() throws ServletException {
        LOGGER.info("method executed {}","init()");
        super.init();
    }
    // every request
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("method executed {}","service()");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("method executed {}","doGet()");
//        super.doGet(req, resp);
        resp.getWriter().write("doGet Servlet Life Cycle");
    }

    // one time on container termination
    @Override
    public void destroy() {
        LOGGER.info("method executed {}","destroy()");
        super.destroy();
    }
}
