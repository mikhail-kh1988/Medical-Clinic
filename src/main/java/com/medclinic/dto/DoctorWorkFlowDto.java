package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWorkFlowDto {

    @Future
    private String startDateWorkFlow;

    @Future
    private String endDateWorkFlow;

    private long serviceId;

}
