package com.example.demo.Service;

import org.springframework.stereotype.Service; 

@Service
public class UserSerivce {
    public Integer getUserId() {
        System.out.println("entering the UserService's getUserId");
        int userId = 5;
        return userId;
    }

}
