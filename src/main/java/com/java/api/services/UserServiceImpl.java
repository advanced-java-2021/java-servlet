package com.java.api.services;

import com.java.api.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements IUserService{
    // to store data of logged in users.
    private static Map<String, User> emailUserMapping = new HashMap<>();

    // this will allow to create only one object of the class
    private static UserServiceImpl INSTANCE = new UserServiceImpl();

    // public method to create object of the class.
    public static IUserService getInstance(){
        return INSTANCE;
    }

    // private constructor to prevent creation of objects
    private UserServiceImpl(){
        User u1 = new User();
        u1.setEmail("default@123");
        u1.setPassword("default");
        u1.setId(UUID.randomUUID().toString());
        emailUserMapping.putIfAbsent(u1.getEmail(),u1);
    }

    @Override
    public int save(User u) {
        emailUserMapping.putIfAbsent(u.getEmail(),u);
        return emailUserMapping.size();
    }

    @Override
    public User getByEmail(String email) {
        return emailUserMapping.get(email);
    }
}
