package com.java.api.services;

import com.java.api.models.User;

public interface IUserService {
    int save(User u);
    User getByEmail(String email);
}
