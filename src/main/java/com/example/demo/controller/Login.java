package com.example.demo.controller;


import com.example.demo.params.LoginParams;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginParams loginParams) {
        System.out.print(loginParams);
        return loginService.login(loginParams);
    }
}
