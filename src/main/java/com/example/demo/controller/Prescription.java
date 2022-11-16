package com.example.demo.controller;

import com.example.demo.params.PrescriptionByAppointmentIdParams;
import com.example.demo.params.PrescriptionByEmailParams;
import com.example.demo.params.PrescriptionParams;
import com.example.demo.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prescription {
    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/addPrescription")
    public ResponseEntity<Object> addPrescription(@RequestBody PrescriptionParams prescriptionParams) {
        return prescriptionService.addPrescription(prescriptionParams);
    }

    //by user email
    @PostMapping("/prescriptionByEmail")
    public ResponseEntity<Object> prescriptionByEmail(@RequestBody PrescriptionByEmailParams prescriptionByEmailParams) {
        return prescriptionService.prescriptionByEmail(prescriptionByEmailParams);
    }

    //by appointment id
    @PostMapping("/prescriptionByAppointment")
    public ResponseEntity<Object> prescriptionByAppointment(@RequestBody PrescriptionByAppointmentIdParams prescriptionByAppointmentIdParams) {
        return prescriptionService.prescriptionByAppointment(prescriptionByAppointmentIdParams);
    }
}