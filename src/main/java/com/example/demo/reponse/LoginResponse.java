package com.example.demo.reponse;

import com.example.demo.table.AdminTable;
import com.example.demo.table.DoctorTable;
import com.example.demo.table.UserTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    UserTable userTable;
    DoctorTable doctorTable;
    AdminTable adminTable;
    String role;

    public LoginResponse(DoctorTable doctorTable, String role) {
        this.doctorTable = doctorTable;
        this.role = role;
    }

    public LoginResponse(UserTable userTable, String role) {
        this.userTable = userTable;
        this.role = role;
    }

    public LoginResponse(AdminTable adminTable, String role) {
        this.adminTable = adminTable;
        this.role = role;
    }
}
