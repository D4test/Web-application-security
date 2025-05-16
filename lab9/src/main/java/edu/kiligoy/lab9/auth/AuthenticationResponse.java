package edu.kiligoy.lab9.auth;

/*
@author   Dtest
@project   lab8
@class  AuthenticationResponse
@version  1.0.0
@since 16.05.2025 - 02.08
*/

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthenticationResponse {
    private String token;
}
