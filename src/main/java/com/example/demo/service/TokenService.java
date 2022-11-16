package com.example.demo.service;

import com.example.demo.params.TokenParams;
import com.example.demo.params.TokenReturnParams;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.repository.TokenRepository;
import com.example.demo.table.TokenTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    public ResponseEntity<Object> token(TokenParams params) {
        try {
            boolean check = tokenRepository.existsByEmail(params.getEmail());
            if (check) {
                tokenRepository.token(params.getEmail(), params.getToken());
            } else {
                tokenRepository.save(new TokenTable(params.getEmail(), params.getToken()));
            }
            return new ResponseEntity<>(new TokenTable(params.getEmail(), params.getToken()), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> tokenReturn(TokenReturnParams params) {
        try {
            TokenTable tokenReturn = tokenRepository.tokenByEmail(params.getEmail());
            return new ResponseEntity<>(tokenReturn, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
