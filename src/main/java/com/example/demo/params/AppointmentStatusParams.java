package com.example.demo.params;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentStatusParams {

    private String doctorEmail;
    private int isAccepted;
}
