package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDTO {
    private String name;
    private String internalCode;
    private String externalCode;
    private String worldCode;

}
