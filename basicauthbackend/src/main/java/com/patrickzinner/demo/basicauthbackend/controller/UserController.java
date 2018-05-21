package com.patrickzinner.demo.basicauthbackend.controller;

import com.patrickzinner.demo.basicauthbackend.controller.model.RegisterUserModel;
import com.patrickzinner.demo.basicauthbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = "application/json")
    public void signUp(@RequestBody RegisterUserModel user) {
        userService.createUser(user.getUsername(), user.getEmailAddress(),user.getPassword());
    }


    @RequestMapping(value = "/signup/test", method = RequestMethod.GET)
    public String signUp() {
       return "test";
    }
}
