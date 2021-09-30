package com.java.api.filter;

import com.java.api.models.TokenInfo;
import com.java.api.services.AuthTokenServiceImpl;
import com.java.api.services.IAuthTokenService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter implements Filter {

    private static IAuthTokenService authTokenService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        authTokenService = AuthTokenServiceImpl.getInstance();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        TokenInfo tokenInfo = authTokenService.validateToken(token);

        if (tokenInfo != null){
            System.out.println("user logged in : "+tokenInfo.getEmail());
            chain.doFilter(request, response);
        }
        else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(401);
            httpServletResponse.getWriter().write("Invalid Auth Token");
        }
    }

    @Override
    public void destroy() {

    }
}
