package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWorkFlowDto {

    @Future
    private String startDateWorkFlow;

    @Future
    private String endDateWorkFlow;

    @Min(1)
    private long serviceId;

}
