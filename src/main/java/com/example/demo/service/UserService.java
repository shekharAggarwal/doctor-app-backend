package com.example.demo.service;

import com.example.demo.params.GetUserByEmailParams;
import com.example.demo.params.RegisterParams;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.reponse.LoginResponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.table.RoleTable;
import com.example.demo.table.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<Object> register(RegisterParams params)  {
        try {
            roleRepository.save(new RoleTable(params.getEmail(), "user"));
            UserTable user = userRepository.save(new UserTable(params.getEmail(), params.getName(),
                    params.getPassword(),
                    params.getAadhaarNumber(),
                    params.getAddress(),
                    params.getDob(),
                    params.getGender(),
                    params.getBloodGroup(),
                    params.getWeight(),
                    params.getHeight(),
                    params.getInsuranceNumber(),
                    params.getHeartProblem(),
                    params.getAllergy()));
            return new ResponseEntity<>(new LoginResponse(user, "user"), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);

        }
    }

    public ResponseEntity<Object> getUserByEmail(GetUserByEmailParams params) {
        try {
            UserTable user = userRepository.getUserByEmail(params.getEmail());
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }


}


