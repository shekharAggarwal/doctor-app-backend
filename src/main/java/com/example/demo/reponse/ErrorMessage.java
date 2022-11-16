package com.example.demo.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ErrorMessage  {
    String errorMessage;
    HttpStatus code;

    public ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
