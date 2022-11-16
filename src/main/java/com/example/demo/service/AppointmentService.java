package com.example.demo.service;

import com.example.demo.params.*;
import com.example.demo.reponse.ErrorMessage;
import com.example.demo.reponse.appointmentResponse;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.table.AppointmentTable;
import com.example.demo.table.PrescriptionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PrescriptionRepository repository;

    public ResponseEntity<Object> bookAppointment(AppointmentParams params) {
        try {
            AppointmentTable appointment = appointmentRepository
                    .save(new AppointmentTable(params.getDoctorEmail(), params.getDoctorName(),
                            params.getUserName(), 0, params.getUserEmail(),
                            params.getAppointmentTime(), params.getPrescriptionId(),
                            params.getUserId()));

            return new ResponseEntity<>(appointment, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> getAppointmentByStatus(AppointmentStatusParams params) {
        try {
            List<AppointmentTable> appointmentStatus = appointmentRepository
                    .appointmentStatus(params.getDoctorEmail(), params.getIsAccepted());
            return new ResponseEntity<>(appointmentStatus, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> updateAppointmentStatus(StatusUpdate params) {
        try {
            int appointment = appointmentRepository.status(params.getId(), params.getIsAccepted());
            return new ResponseEntity<>(appointment, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }


    public ResponseEntity<Object> appointmentDetails(String appointmentId) {
        try {
            AppointmentTable appointment = appointmentRepository.getAppointmentId(Long.parseLong(appointmentId));

            PrescriptionTable prescription = repository
                    .prescriptionById(Long.parseLong(appointment.getPrescriptionId()));

            return new ResponseEntity<>(new appointmentResponse(appointment, prescription), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> appointmentPending(AppointmentByPendingParams params) {
        try {
            List<AppointmentTable> appointmentByPending = appointmentRepository
                    .appointmentByPending(params.getEmail());

            return new ResponseEntity<>(appointmentByPending, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> appointmentCompleted(AppointmentCompletedParams params) {
        try {
            List<AppointmentTable> appointmentCompleted = appointmentRepository
                    .appointmentCompleted(params.getEmail());

            return new ResponseEntity<>(appointmentCompleted, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> appointmentUpdateByDoctor(PrescriptionParams params) {
        try {
            PrescriptionTable prescription = repository.save(new PrescriptionTable(params.getDoctorEmail(),
                    params.getUserEmail(), params.getReason(), params.getSymptoms(), params.getPrescription(),
                    params.getAppointmentTime(), params.getAppointmentId()));

            int check = appointmentRepository.updateStatusOfAppointment("" + prescription.getId(),
                    Long.parseLong(params.getAppointmentId()));
            return new ResponseEntity<>(check, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
}
