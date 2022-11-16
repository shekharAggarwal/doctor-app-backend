package com.example.demo.reponse;

import com.example.demo.table.AppointmentTable;
import com.example.demo.table.PrescriptionTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class appointmentUpdateByDoctorResponse {

    AppointmentTable appointmentTable;
    PrescriptionTable prescriptionTable;
}
