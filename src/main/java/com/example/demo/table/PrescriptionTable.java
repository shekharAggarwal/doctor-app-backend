package com.example.demo.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "prescription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrescriptionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String doctorEmail;
    private String userEmail;
    private String reason;
    private String symptoms;
    private String prescription;
    private Date appointmentTime;
    private String appointmentId;


    public PrescriptionTable(String doctorEmail, String userEmail, String reason, String symptoms, String prescription, Date appointmentTime, String appointmentId) {
        this.doctorEmail = doctorEmail;
        this.userEmail = userEmail;
        this.reason = reason;
        this.symptoms = symptoms;
        this.prescription = prescription;
        this.appointmentTime = appointmentTime;
        this.appointmentId = appointmentId;
    }
}
