package edu.kiligoy.lab9.auth;

/*
@author   Dtest
@project   lab8
@class  AuthenticationRequest
@version  1.0.0
@since 16.05.2025 - 02.08
*/

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @Email(message = "Email is not well formatted")
    @NotEmpty(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @Size(min = 6, message = "Password should be at least 6 characters")
    private String password;
}