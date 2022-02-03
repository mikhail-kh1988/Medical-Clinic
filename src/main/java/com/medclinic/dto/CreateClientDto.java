package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientDto {
    @Max(20)
    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @NotBlank
    private String familyName;

    @Email
    private String email;

    @Max(120)
    private int age;

    @NotBlank
    private String about;

    @NotBlank
    private String actualAddress;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String birthDay;
}
