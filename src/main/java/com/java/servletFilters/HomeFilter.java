package com.java.servletFilters;


import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class HomeFilter implements Filter {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApplicationFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // one time
        LOGGER.info("filter() executed {}","init() - home filter");
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
        LOGGER.info("filter() executed {}","destroy() - home filter");
    }
}
