package com.proj.spring_boot_rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proj.spring_boot_rest.model.User;
import com.proj.spring_boot_rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
