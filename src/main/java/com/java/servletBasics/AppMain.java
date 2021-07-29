package com.java.servletBasics;

public class AppMain {
    private  abstract static class HttpServlet{
        public void service(){
            System.out.println("default");
        }
    }

    private static  class TestServlet extends HttpServlet {
        @Override
        public void service() {
//            super.service();
            System.out.println("costum logic");
        }
    }

    public static void main(String[] args) {
        HttpServlet a = new TestServlet();
        a.service();
    }
}
