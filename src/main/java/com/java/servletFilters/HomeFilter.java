package com.java.servletFilters;


import javax.servlet.*;
import java.io.IOException;

public class HomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // one time
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before "+this.getClass());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after "+this.getClass());
    }

    @Override
    public void destroy() {
        // one time
    }
}
