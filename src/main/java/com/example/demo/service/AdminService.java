package com.example.demo.service;

import com.example.demo.params.changeUserStatusParams;
import com.example.demo.params.getUserByStatusParams;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.repository.UserRepository;
import com.example.demo.table.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> changeUserStatus(changeUserStatusParams params) {
        try {
            int user = userRepository.changeUserStatus(params.getUserEmail(), params.isStatus());
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> getUserByStatus(getUserByStatusParams params) {
        try {
            List<UserTable> user = userRepository.getUserByStatus(params.isStatus());
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
