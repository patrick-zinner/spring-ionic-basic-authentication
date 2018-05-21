package com.patrickzinner.demo.basicauthbackend.controller;

import com.patrickzinner.demo.basicauthbackend.controller.model.RegisterUserModel;
import com.patrickzinner.demo.basicauthbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup", consumes = "application/json")
    public void signUp(@RequestBody RegisterUserModel user) {
        userService.createUser(user.getUsername(), user.getEmailAddress(), user.getPassword());
    }

}
