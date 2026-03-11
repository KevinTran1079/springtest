package com.kevintran1079.springtest.controller;

import com.kevintran1079.springtest.model.User;
import com.kevintran1079.springtest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userSerivce;

    public UserController(UserService userSerivce){
        this.userSerivce = userSerivce;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userSerivce.getAllUsers();
    }
}
