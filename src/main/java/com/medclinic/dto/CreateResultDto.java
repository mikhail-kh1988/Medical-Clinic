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
public class CreateResultDto {

    @Positive
    public long analysisID;

    @Positive
    public long serviceID;

    @Positive
    public long doctorID;

    @Positive
    public long clientID;

}
