package com.java.servletFilters;


import javax.servlet.*;
import java.io.IOException;
// what filter do in servlet?
// every time we sent an req form web browser, the control first comes to the servlet filter
// then after it goes to the servlet application
// Filter :
// filter has 3 methods
// init : runs only once (any logic within filter only runs one time)
// doFilter : it runs more than one time, here we can call another filter or we can directly
// execute the servlet.
// destroy : runs only once (any logic within filter only runs one time)

public class ApplicationFilter implements Filter {
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
