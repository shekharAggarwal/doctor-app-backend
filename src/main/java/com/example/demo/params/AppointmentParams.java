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
public class AppointmentParams {
    private String doctorEmail;
    private String userEmail;
    private String doctorName;
    private String prescriptionId;
    private Date appointmentTime;
    private String userName;
    private String userId;
}
