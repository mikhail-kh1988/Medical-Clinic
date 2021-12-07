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
    @NotEmpty
    private String password;

    @NotBlank
    private String fullName;

    @NotBlank
    private String familyName;

    @Email
    private String email;

    @Max(120)
    @Positive
    private int age;

    private String about;
    private String actualAddress;
    private String phoneNumber;
    private String birthDay;
}
