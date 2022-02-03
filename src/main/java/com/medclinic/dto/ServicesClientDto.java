package com.medclinic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicesClientDto {

    @Min(1)
    private long clientID;

    @Min(1)
    private long analysisID;

    @Min(1)
    private long serviceID;

    @Min(1)
    private long doctorID;

}
