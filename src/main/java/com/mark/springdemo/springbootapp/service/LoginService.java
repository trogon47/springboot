package com.mark.springdemo.springbootapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(String userId, String password) {
        return userId.equals("mark") && password.equals("pallass1");
    }
}
