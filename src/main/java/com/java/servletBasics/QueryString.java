package com.java.servletBasics;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class QueryString extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        accessAsKeyValue(req);
        accessUsingKeyValue(req);
        resp.getWriter().write("doGet() executed..");
    }

    private void accessUsingKeyValue(HttpServletRequest req) {
        System.out.println("access using map");
        System.out.println("====================");

        Map<String, String[]> map = req.getParameterMap();
        for(Map.Entry<String, String[]> entry  : map.entrySet()){
            System.out.println("key : "+entry.getKey());
            System.out.println("values  : "+ Arrays.toString(entry.getValue()));
            System.out.println("values : "+ Arrays.toString(entry.getValue()));
        }
    }

    private void accessAsKeyValue(HttpServletRequest req) {
        System.out.println("access as key value");
        System.out.println("====================");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("id= " + id + " name= " + name + " age=" + age);
    }
}
