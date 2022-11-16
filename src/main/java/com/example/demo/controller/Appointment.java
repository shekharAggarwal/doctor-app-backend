package com.example.demo.controller;


import com.example.demo.params.*;
import com.example.demo.service.AppointmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Appointment {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<Object> bookAppointment(@RequestBody AppointmentParams appointmentParams) {
        return appointmentService.bookAppointment(appointmentParams);
    }

    @PostMapping("/appointmentDetails")
    public ResponseEntity<Object> appointmentDetails(@RequestBody @NotNull AppointmentDetailsParams
                                                             appointmentDetailsParams) {
        return appointmentService.appointmentDetails(appointmentDetailsParams.getAppointmentId());
    }

    @PostMapping("/updateAppointmentStatus")
    public ResponseEntity<Object> updateAppointmentStatus(@RequestBody StatusUpdate statusUpdate) {
        return appointmentService.updateAppointmentStatus(statusUpdate);
    }

    @PostMapping("/getAppointmentByStatus")
    public ResponseEntity<Object> getAppointmentByStatus(@RequestBody AppointmentStatusParams
                                                                 appointmentStatusParams) {
        return appointmentService.getAppointmentByStatus(appointmentStatusParams);
    }

    @PostMapping("/appointmentPending")
    public ResponseEntity<Object> appointmentPending(@RequestBody AppointmentByPendingParams
                                                             appointmentByPendingParams) {
        return appointmentService.appointmentPending(appointmentByPendingParams);
    }

    @PostMapping("/appointmentCompleted")
    public ResponseEntity<Object> appointmentCompleted(@RequestBody AppointmentCompletedParams
                                                               appointmentCompletedParams) {
        return appointmentService.appointmentCompleted(appointmentCompletedParams);
    }

    @PostMapping("/appointmentUpdateByDoctor")
    public ResponseEntity<Object> appointmentUpdateByDoctor(@RequestBody PrescriptionParams
                                                                    prescriptionParams) {
        return appointmentService.appointmentUpdateByDoctor(prescriptionParams);
    }
}
