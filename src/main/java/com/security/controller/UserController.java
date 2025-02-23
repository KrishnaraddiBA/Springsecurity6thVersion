package com.security.controller;

import com.security.entity.Users;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public Users saveData(@RequestBody Users user){
        Users users = userService.saveUser(user);
        return users;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return userService.validateUser(users);
    }


}
