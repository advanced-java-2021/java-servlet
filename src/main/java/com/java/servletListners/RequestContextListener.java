package com.java.servletListners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestContextListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request initialized "+this.getClass());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request destroyed "+this.getClass());
    }
}
