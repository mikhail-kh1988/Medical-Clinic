package com.medclinic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicesClientDto {

    @Positive
    private long clientID;

    @Positive
    private long analysisID;

    @Positive
    private long serviceID;

    @Positive
    private long doctorID;

}
