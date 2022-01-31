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
public class PillDto {

    @NotBlank
    private String name;

    @NotBlank
    private String activeElement;

    @NotBlank
    private String composition;

    @NotBlank
    private String dosage;
    
}
