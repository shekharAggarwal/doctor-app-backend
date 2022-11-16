package com.example.demo.controller;

import com.example.demo.params.GetUserByEmailParams;
import com.example.demo.params.RegisterParams;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

    @Autowired
    UserService userService;


    @PostMapping("/registerUser")
    public ResponseEntity<Object> register(@RequestBody RegisterParams registerParams) {
        return userService.register(registerParams);
    }

    @PostMapping("/getUserByEmail")
    public ResponseEntity<Object> getUserByEmail(@RequestBody GetUserByEmailParams getUserByEmailParams) {
        return userService.getUserByEmail(getUserByEmailParams);
    }
}
