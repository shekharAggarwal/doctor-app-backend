package com.example.demo.controller;

import com.example.demo.params.UpdateDoctorParams;
import com.example.demo.params.changeUserStatusParams;
import com.example.demo.params.getUserByStatusParams;
import com.example.demo.service.AdminService;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin {


    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;

    //changing user status of User (Block or Unblock)
    @PostMapping("/changeUserStatus")
    public ResponseEntity<Object> changeUserStatus(@RequestBody changeUserStatusParams params) {
        return adminService.changeUserStatus(params);
    }

    @PostMapping("/pendingDoctor")
    public ResponseEntity<Object> pendingDoctor() {
        return doctorService.pendingDoctor();
    }

    @PostMapping("/acceptedDoctor")
    public ResponseEntity<Object> acceptedDoctor() {
        return doctorService.acceptedDoctor();
    }

    @PostMapping("/rejectedDoctor")
    public ResponseEntity<Object> rejectedDoctor() {
        return doctorService.rejectedDoctor();
    }

    @PostMapping("/updateDoctorStatus")
    public ResponseEntity<Object> updateDoctorStatus(@RequestBody UpdateDoctorParams params) {
        return doctorService.updateDoctorStatus(params);
    }

    @PostMapping("/getUserByStatus")
    public ResponseEntity<Object> getUserByStatus(@RequestBody getUserByStatusParams params) {
        return adminService.getUserByStatus(params);
    }
}
