package com.example.demo.controller;

import com.example.demo.params.DoctorsParams;
import com.example.demo.params.SearchParams;
import com.example.demo.params.SpecializationDoctorParams;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Doctor {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/registerDoctor")
    public ResponseEntity<Object> doctor(@RequestBody DoctorsParams doctorsParams){
        return doctorService.doctor(doctorsParams);
    }

    @PostMapping("/allDoctor")
    public ResponseEntity<Object> allDoctor() {
        return doctorService.allDoctor();
    }

    @PostMapping("/specializationDoctor")
    public ResponseEntity<Object> specializationDoctor(@RequestBody SpecializationDoctorParams params) {
        return doctorService.specializationDoctor(params);
    }

    @PostMapping("/search")
    public ResponseEntity<Object> search(@RequestBody SearchParams params) {
        return doctorService.searchDoctor(params);
    }
}