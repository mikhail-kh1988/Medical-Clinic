package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private String login;
    private String password;
    private String email;
    private Integer age;
    private String fullName;
    private String familyName;
    private String whereStudy;
    private String specializationName;
    private String certificateNumber;

}
