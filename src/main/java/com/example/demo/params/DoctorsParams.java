package com.example.demo.params;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsParams {
    private String name;
    private String address;
    private String degree;
    private String email;
    private String password;

}
