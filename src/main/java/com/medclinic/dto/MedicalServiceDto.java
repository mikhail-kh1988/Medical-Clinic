package com.medclinic.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalServiceDto {

    @NotBlank
    @NotEmpty
    private String name;
    private String describe;
    private int price;
    private boolean active;
    private String externalCode;

}
