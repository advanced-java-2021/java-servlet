package com.java.api.services;

import com.java.api.models.TokenInfo;

public interface IAuthTokenService {
    String generateToken(String email);
    TokenInfo validateToken(String token);
}
