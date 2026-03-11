package com.kevintran1079.springtest.controller;

import com.kevintran1079.springtest.dto.UserResponse;
import com.kevintran1079.springtest.model.User;
import com.kevintran1079.springtest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(){
        return userService.getAllUsers()
                .stream()
                .map(this::toUserResponse)
                .toList();
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
