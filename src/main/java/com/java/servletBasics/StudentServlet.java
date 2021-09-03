package com.java.servletBasics;

import com.java.jaksonUtils.JacksonUtils;
import com.java.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        Student s = new Student();
        s.setGender("male");
        s.setRoll(UUID.randomUUID().toString());
        s.setName("Bablu");

        String jsonData = JacksonUtils.toJson(s);
        // serialization
        resp.getWriter().write(jsonData);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        // deserialization
        InputStream is = req.getInputStream();
        System.out.println("Input stream type "+ this.getClass());
        Student s = JacksonUtils.toObject(is, Student.class);
        resp.getWriter().write(s.getName()+" post Method");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPut(req, resp);
        String name = req.getParameter("name");
        InputStream is = req.getInputStream();
        System.out.println("is type : "+this.getClass());
        Student s = JacksonUtils.toObject(is, Student.class);
        resp.getWriter().write( " put method "+ s.getName());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doDelete(req, resp);
        String name = req.getParameter("name");
        InputStream is = req.getInputStream();
        Student s = JacksonUtils.toObject(is, Student.class);
        resp.getWriter().write(s.getName()+" delete method ");

    }
}
