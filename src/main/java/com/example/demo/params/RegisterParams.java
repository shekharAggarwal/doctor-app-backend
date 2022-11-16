package com.example.demo.params;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterParams {
    private String email;
    private String password;
    private String name;
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
}
