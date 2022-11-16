package com.example.demo.service;


import com.example.demo.params.LoginParams;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.reponse.LoginResponse;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.table.AdminTable;
import com.example.demo.table.DoctorTable;
import com.example.demo.table.RoleTable;
import com.example.demo.table.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RoleRepository roleRepository;


    public ResponseEntity<Object> login(LoginParams params) {
        try {
            RoleTable role = roleRepository.role(params.getEmail());
            if (role.getRole().equals("user")) {
                return loginUser(params);
            } else if (role.getRole().equals("doctor")) {
                return loginDoctor(params);
            } else if (role.getRole().equals("admin")) {
                return loginAdmin(params);
            }
            return new ResponseEntity<>(new ErrorMessage("no user found!"), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    private ResponseEntity<Object> loginUser(LoginParams params) {
        try {
            UserTable user = userRepository.Login(params.getEmail(), params.getPassword());
            return new ResponseEntity(new LoginResponse(user, "user"), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    private ResponseEntity<Object> loginDoctor(LoginParams params) {
        try {
            DoctorTable doctor = doctorRepository.loginDoctor(params.getEmail(), params.getPassword());
            return new ResponseEntity<>(new LoginResponse(doctor, "doctor"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }


    private ResponseEntity<Object> loginAdmin(LoginParams params) {
        try {
            AdminTable admin = adminRepository.admin(params.getEmail(), params.getPassword());
            return new ResponseEntity(new LoginResponse(admin, "admin"), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
