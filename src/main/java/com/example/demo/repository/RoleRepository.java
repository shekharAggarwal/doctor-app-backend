package com.example.demo.repository;

import com.example.demo.table.RoleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<RoleTable, Long> {
    @Query("FROM RoleTable u where u.email=?1")
    RoleTable role(String email);
}
