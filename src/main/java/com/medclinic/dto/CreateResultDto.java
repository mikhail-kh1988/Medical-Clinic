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
public class CreateResultDto {

    @Min(1)
    public long analysisID;

    @Min(1)
    public long serviceID;

    @Min(1)
    public long doctorID;

    @Min(1)
    public long clientID;

}
