package com.java.signupAndLogin;

import com.java.jaksonUtils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SignUp extends HttpServlet {
    public static Map<String, User> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // super.init();
        User u1 = new User();
        u1.setEmail("default@123");
        u1.setPassword("default");
        u1.setId(UUID.randomUUID().toString());
        map.putIfAbsent(u1.getEmail(),u1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        User user = new User();
        InputStream is = req.getInputStream();
        user = JacksonUtils.toObject(is, User.class);
        map.putIfAbsent(user.getEmail(),user);
        System.out.println("users registered "+map.size());
        resp.getWriter().write("users registered "+map.size());
    }
}
