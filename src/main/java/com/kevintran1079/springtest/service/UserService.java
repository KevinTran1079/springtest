package com.kevintran1079.springtest.service;

import com.kevintran1079.springtest.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> getAllUsers(){
        return List.of(
                new User(1L, "Kevin", "password", "kevin@test.com"),
                new User(2L, "Roy", "password", "roy@test.com")
        );
    }
}
