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
public class MedicalServiceDto {

    @NotBlank
    private String name;

    @NotBlank
    private String describe;

    @Min(1)
    private int price;
    private boolean active;

    @NotBlank
    private String externalCode;

}
