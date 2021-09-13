package com.java.api.controller;

import com.java.api.models.User;
import com.java.api.services.IUserService;
import com.java.api.services.UserServiceImpl;
import com.java.jaksonUtils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class SignUpServlet extends HttpServlet {

    private static IUserService userService;

    @Override
    public void init() throws ServletException {
        // super.init();
        // only one objected created
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        InputStream is = req.getInputStream();
        User u = JacksonUtils.toObject(is, User.class);

        int size = userService.save(u);

        System.out.println("users registered = "+ size);

        resp.getWriter().write("users registered = "+ size);
    }
}
