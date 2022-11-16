package com.example.demo.params;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionParams {
    private String doctorEmail;
    private String userEmail;
    private String reason;
    private String symptoms;
    private String prescription;
    private Date appointmentTime;
    private String appointmentId;
}
