package com.example.demo.repository;

import com.example.demo.table.DoctorTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorTable, Long> {

    @Query("FROM DoctorTable u Where u.degree=?1 and u.accepted=true and u.rejected=false")
    List<DoctorTable> doctorsByDegree(String degree);

    @Query("FROM DoctorTable u Where u.email=?1 AND u.password=?2")
    DoctorTable loginDoctor(String email, String Password);

    @Query("FROM DoctorTable u Where u.name LIKE %?1% and u.accepted=true and u.rejected=false")
    List<DoctorTable> searchDoctor(String query);

    @Query("FROM DoctorTable u Where u.accepted=false AND u.rejected=false")
    List<DoctorTable> pendingDoctor();

    @Query("FROM DoctorTable u Where u.accepted=false AND u.rejected=true")
    List<DoctorTable> rejectedDoctor();

    @Query("FROM DoctorTable u Where u.accepted=true AND u.rejected=false")
    List<DoctorTable> acceptedDoctor();

    @Transactional
    @Modifying
    @Query("UPDATE DoctorTable u set u.accepted=?2,u.rejected=?3  Where u.email=?1")
    int updateDoctor(String doctorEmail, boolean status, boolean notStatus);


    @Query("FROM DoctorTable u Where u.accepted=true and u.rejected=false")
    List<DoctorTable> getAllDoctor();
}
