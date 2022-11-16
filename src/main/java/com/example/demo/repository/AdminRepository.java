package com.example.demo.repository;

import com.example.demo.table.AdminTable;
import com.example.demo.table.PrescriptionTable;
import com.example.demo.table.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<AdminTable, Long> {
    @Query("FROM AdminTable u Where u.email=?1 AND u.password=?2")
    AdminTable admin(String email, String Password);
}
