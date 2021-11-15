package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientDTO {
    private String login;
    private String password;
    private String fullName;
    private String familyName;
    private String email;
    private int age;
    private String about;
    private String actualAddress;
    private String phoneNumber;
    private String birthDay;
}
