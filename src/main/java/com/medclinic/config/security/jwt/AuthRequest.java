package com.medclinic.config.security.jwt;

import lombok.Data;

@Data
public class AuthRequest {

    private String Login;
    private String password;

}
