package com.example.demo.service;


import com.example.demo.params.DoctorsParams;
import com.example.demo.params.SearchParams;
import com.example.demo.params.SpecializationDoctorParams;
import com.example.demo.params.UpdateDoctorParams;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.reponse.LoginResponse;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.table.DoctorTable;
import com.example.demo.table.RoleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<Object> doctor(DoctorsParams params){
        try {
            roleRepository.save(new RoleTable(params.getEmail(), "doctor"));
            DoctorTable doctor = doctorRepository.save(new DoctorTable(params.getName(), params.getAddress(), params.getDegree(), params.getEmail(), params.getPassword()));
            return new ResponseEntity<>(new LoginResponse(doctor, "doctor"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> allDoctor() {
        try {
            List<DoctorTable> allDoctor = doctorRepository.getAllDoctor();
            return new ResponseEntity<>(allDoctor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> specializationDoctor(SpecializationDoctorParams params) {
        try {
            List<DoctorTable> specializationDoctor = doctorRepository.doctorsByDegree(params.getSpecialization());
            return new ResponseEntity<>(specializationDoctor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> searchDoctor(SearchParams params) {
        try {
            List<DoctorTable> searchDoctor = doctorRepository.searchDoctor(params.getQuery());
            return new ResponseEntity<>(searchDoctor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> pendingDoctor() {
        try {
            List<DoctorTable> pendingDoctor = doctorRepository.pendingDoctor();
            return new ResponseEntity<>(pendingDoctor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> rejectedDoctor() {
        try {
            List<DoctorTable> rejectedDoctor = doctorRepository.rejectedDoctor();
            return new ResponseEntity<>(rejectedDoctor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> acceptedDoctor() {
        try {
            List<DoctorTable> acceptedDoctor = doctorRepository.acceptedDoctor();
            return new ResponseEntity<>(acceptedDoctor, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> updateDoctorStatus(UpdateDoctorParams params) {
        try {
            int updateDoctorStatus = doctorRepository.updateDoctor(params.getDoctorEmail(), params.isStatus(), !params.isStatus());
            return new ResponseEntity<>(updateDoctorStatus, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
