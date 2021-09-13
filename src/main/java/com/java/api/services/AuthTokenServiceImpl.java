package com.java.api.services;

import com.java.api.models.TokenInfo;
import com.java.jaksonUtils.JacksonUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class AuthTokenServiceImpl implements IAuthTokenService{

    private static AuthTokenServiceImpl INSTANCE = new AuthTokenServiceImpl();

    public static IAuthTokenService getInstance(){
        return INSTANCE;
    }

    @Override
    public String generateToken(String email) {
        int N = 5;

        long currentTimeMs = System.currentTimeMillis();
        long after_N_Minutes = currentTimeMs + TimeUnit.MINUTES.toMillis(N);

        TokenInfo tokenInfo = new TokenInfo(email, after_N_Minutes);
        String rawToken = JacksonUtils.toJson(tokenInfo);
        String encodedToken = Base64.getEncoder().encodeToString(rawToken.getBytes(StandardCharsets.UTF_8));
        return encodedToken;
    }

    @Override
    public TokenInfo validateToken(String token) {
        return null;
    }

    public static void main(String[] args) {
        long currentTimeMS = System.currentTimeMillis();
        System.out.println(currentTimeMS);

        long nextMS = currentTimeMS + TimeUnit.MINUTES.toMillis(5);
        System.out.println(nextMS - currentTimeMS);

//        IAuthTokenService authTokenService = getInstance();

//        String token = authTokenService.generateToken("abc@gmail.com");
//        TokenInfo tokenInfo = authTokenService.validateToken(token);
//
//        System.out.println(tokenInfo);

    }
}
