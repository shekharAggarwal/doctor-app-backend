package com.example.demo.service;

import com.example.demo.params.PrescriptionByAppointmentIdParams;
import com.example.demo.params.PrescriptionByEmailParams;
import com.example.demo.params.PrescriptionParams;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.table.PrescriptionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    PrescriptionRepository prescriptionRepository;


    public ResponseEntity<Object> addPrescription(PrescriptionParams params) {
        try {
            PrescriptionTable prescription = prescriptionRepository
                    .save(new PrescriptionTable(params.getDoctorEmail(), params.getUserEmail(),
                            params.getReason(), params.getSymptoms(), params.getPrescription(),
                            params.getAppointmentTime(), params.getAppointmentId()));
            return new ResponseEntity<>(prescription, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> prescriptionByEmail(PrescriptionByEmailParams params) {
        try {
            List<PrescriptionTable> prescription = prescriptionRepository
                    .prescriptionByEmail(params.getUserEmail());
            return new ResponseEntity<>(prescription, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> prescriptionByAppointment(PrescriptionByAppointmentIdParams params) {
        try {
            PrescriptionTable Prescription = prescriptionRepository
                    .prescriptionByAppointment(params.getAppointmentId());

            return new ResponseEntity<>(Prescription, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
