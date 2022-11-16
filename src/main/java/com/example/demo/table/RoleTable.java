package com.example.demo.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RoleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Column(unique = true)
    private String email;
    private String role;

    public RoleTable(String email, String role) {
        this.email = email;
        this.role = role;
    }
}
