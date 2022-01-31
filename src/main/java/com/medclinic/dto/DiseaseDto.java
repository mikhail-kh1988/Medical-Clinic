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
public class DiseaseDto {
    @NotBlank
    private String name;

    @NotBlank
    private String internalCode;

    @NotBlank
    private String externalCode;

    @NotBlank
    private String worldCode;

}
