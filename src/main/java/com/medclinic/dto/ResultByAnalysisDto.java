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
public class ResultByAnalysisDto {

    @Positive
    private long clientID;

    @Positive
    private long doctorID;

    @Positive
    private long analysisID;

}
