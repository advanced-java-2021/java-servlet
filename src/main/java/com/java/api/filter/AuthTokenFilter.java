package com.java.api.filter;

import com.java.api.services.AuthTokenServiceImpl;
import com.java.api.services.IAuthTokenService;

import javax.servlet.*;
import java.io.IOException;

public class AuthTokenFilter implements Filter {

    private static IAuthTokenService authTokenService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        authTokenService = AuthTokenServiceImpl.getInstance();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
