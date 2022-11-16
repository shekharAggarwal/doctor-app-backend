package com.example.demo.repository;

import com.example.demo.table.TokenTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TokenRepository extends JpaRepository<TokenTable, Long> {

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE TokenTable u set u.token=?2  Where u.email=?1")
    int token(String email, String token);

    @Query("FROM TokenTable u Where u.email=?1")
    TokenTable tokenByEmail(String email);

}
