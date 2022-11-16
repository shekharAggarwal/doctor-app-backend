package com.example.demo.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TokenTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String email;
    private String token;

    public TokenTable(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
