package com.example.demo.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class DoctorTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    private String address;
    private String degree;
    @Column(unique = true)
    private String email;
    private boolean accepted;
    private boolean rejected;


    @JsonIgnore
    private String password;

    public DoctorTable(String name, String address, String degree, String email, String password) {
        this.name = name;
        this.address = address;
        this.degree = degree;
        this.email = email;
        this.accepted = false;
        this.rejected = false;
        this.password = password;
    }

}
