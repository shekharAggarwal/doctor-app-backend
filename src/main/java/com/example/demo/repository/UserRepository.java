package com.example.demo.repository;

import com.example.demo.table.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<UserTable, Long> {

    @Query("FROM UserTable u Where u.email=?1 AND u.password=?2")
    UserTable Login(String email, String Password);

    @Query("FROM UserTable u Where u.email=?1")
    UserTable getUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE UserTable u set u.status=?2  Where u.email=?1")
    int changeUserStatus(String userEmail, boolean status);

    @Query("FROM UserTable u where u.status=?1")
    List<UserTable> getUserByStatus(boolean status);
}
