package com.example.demo.controller;

import com.example.demo.params.TokenParams;
import com.example.demo.params.TokenReturnParams;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Token {

    @Autowired
    TokenService tokenService;

    @PostMapping("/getToken")
    public ResponseEntity<Object> TokenReturn(@RequestBody TokenReturnParams params) {
        return tokenService.tokenReturn(params);
    }

    @PostMapping("/addToken")
    public ResponseEntity<Object> token(@RequestBody TokenParams params) {
        return tokenService.token(params);
    }
}
