package com.medclinic.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalServiceDto {

    private String name;
    private String describe;
    private int price;
    private boolean active;
    private String externalCode;

}
