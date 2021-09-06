package com.java.signupAndLogin;

import com.java.jaksonUtils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        InputStream  is = req.getInputStream();
        User loginReqUser = JacksonUtils.toObject(is, User.class);
        User registeredUser = SignUp.map.get(loginReqUser.getEmail());
        boolean loginSuccess = false;

        if (registeredUser != null){
            if (loginReqUser.getPassword().equals(registeredUser.getPassword()))
            {
                loginSuccess = true;
            }
        }

        if (loginSuccess)
            resp.getWriter().write("login success");

        else
            resp.getWriter().write("login failed");
    }
}
