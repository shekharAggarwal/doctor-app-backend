package com.example.demo.repository;

import com.example.demo.table.PrescriptionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<PrescriptionTable, Long> {

    @Query("FROM PrescriptionTable u Where u.userEmail =?1 Order By u.appointmentTime ASC")
    List<PrescriptionTable> prescriptionByEmail(String userEmail);

    @Query("FROM PrescriptionTable u Where u.appointmentId =?1")
    PrescriptionTable prescriptionByAppointment(String appointment_Id);


    @Query("FROM PrescriptionTable u Where u.id =?1")
    PrescriptionTable prescriptionById(long prescriptionId);


}
