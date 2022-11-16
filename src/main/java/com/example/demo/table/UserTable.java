package com.example.demo.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Column(unique = true)
    private String email;
    private String name;
    @JsonIgnore
    private String password;
    private boolean status;
    private String aadhaarNumber;
    private String address;
    private String dob;
    private String gender;
    private String bloodGroup;
    private String weight;
    private String height;
    private String insuranceNumber;
    private String heartProblem;
    private String allergy;

    public UserTable(String email, String name, String password, String aadhaarNumber, String address, String dob, String gender, String bloodGroup, String weight, String height, String insuranceNumber, String heartProblem, String allergy) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.status = true;
        this.aadhaarNumber = aadhaarNumber;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.weight = weight;
        this.height = height;
        this.insuranceNumber = insuranceNumber;
        this.heartProblem = heartProblem;
        this.allergy = allergy;
    }
}
