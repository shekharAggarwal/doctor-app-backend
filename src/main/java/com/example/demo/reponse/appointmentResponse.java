package com.example.demo.reponse;

import com.example.demo.table.AppointmentTable;
import com.example.demo.table.PrescriptionTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class appointmentResponse {
    AppointmentTable appointmentTable;
    PrescriptionTable prescriptionTable;
}
