package com.medclinic.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalServiceDto {

    @NotBlank
    private String name;

    @NotBlank
    private String describe;

    @Positive
    private int price;
    private boolean active;

    @NotBlank
    private String externalCode;

}
