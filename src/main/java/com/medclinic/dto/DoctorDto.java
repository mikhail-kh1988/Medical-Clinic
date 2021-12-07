package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    @Max(20)
    @NotBlank
    private String login;

    @NotBlank
    @NotEmpty
    private String password;

    @Email
    private String email;

    @Positive
    @Max(120)
    private Integer age;

    @NotBlank
    private String fullName;

    @NotBlank
    private String familyName;

    private String whereStudy;
    private String specializationName;
    private String certificateNumber;

}
