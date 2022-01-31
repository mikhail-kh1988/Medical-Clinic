package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientUpdateDto {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String about;

    @NotBlank
    private String actualAddress;
}
