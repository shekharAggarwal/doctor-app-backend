package com.example.demo.repository;

import com.example.demo.table.AppointmentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentTable, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE AppointmentTable u set u.isAccepted=?2 Where u.id=?1")
    int status(Long id, int isAccepted);

    @Query("FROM AppointmentTable u Where u.doctorEmail=?1 AND u.isAccepted=?2")
    List<AppointmentTable> appointmentStatus(String doctorEmail, int isAccepted);


    @Query("FROM AppointmentTable u Where u.userEmail=?1 and (u.isAccepted=0 OR u.isAccepted=1)")
    List<AppointmentTable> appointmentByPending(String email);

    @Query("FROM AppointmentTable u Where u.userEmail=?1 and (u.isAccepted=2 OR u.isAccepted=3)")
    List<AppointmentTable> appointmentCompleted(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppointmentTable u set u.isAccepted=2,u.prescriptionId=?1 Where u.id=?2")
    int updateStatusOfAppointment(String prescriptionId, long appointmentId);

    @Query("FROM AppointmentTable u Where u.id=?1")
    AppointmentTable getAppointmentId(long id);


}
