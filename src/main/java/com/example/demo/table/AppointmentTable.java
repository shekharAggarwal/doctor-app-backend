package com.example.demo.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppointmentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String doctorEmail;
    private String doctorName;
    private String userName;
    private int isAccepted;
    private String userEmail;
    private Date appointmentTime;
    private String prescriptionId;
    private String userId;

    public AppointmentTable(String doctorEmail, String doctorName, String userName, int isAccepted, String userEmail, Date appointmentTime, String prescription_Id, String user_Id) {
        this.doctorEmail = doctorEmail;
        this.doctorName = doctorName;
        this.userName = userName;
        this.isAccepted = isAccepted;
        this.userEmail = userEmail;
        this.appointmentTime = appointmentTime;
        this.prescriptionId = prescription_Id;
        this.userId = user_Id;
    }
}
