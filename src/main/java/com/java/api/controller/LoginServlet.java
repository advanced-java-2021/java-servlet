package com.java.api.controller;

import com.java.api.models.User;
import com.java.api.services.AuthTokenServiceImpl;
import com.java.api.services.IAuthTokenService;
import com.java.api.services.IUserService;
import com.java.api.services.UserServiceImpl;
import com.java.jaksonUtils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends HttpServlet {
    private static IUserService userService;

    private static IAuthTokenService authTokenService;

    @Override
    public void init() throws ServletException {
        // super.init();
        userService = UserServiceImpl.getInstance();
        authTokenService = AuthTokenServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        InputStream is = req.getInputStream();
        User loginUserRequest = JacksonUtils.toObject(is, User.class);

        User registeredUser = userService.getByEmail(loginUserRequest.getEmail());

        boolean loginSuccess = false;

        if (registeredUser != null){
            if (loginUserRequest.getPassword().equals(registeredUser.getPassword())){
                loginSuccess = true;
            }
        }

        if (loginSuccess){
            resp.setHeader("Authorization", getHeader(registeredUser));
            resp.getWriter().write("login success");
        }

        else{
            resp.setStatus(401);
            resp.getWriter().write("login failed");
        }

    }

    private String getHeader(User user){
        String email = user.getEmail();
        return authTokenService.generateToken(email);
    }
}
