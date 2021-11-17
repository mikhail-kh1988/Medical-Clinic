package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWorkFlowDto {

    private String loginDoctor;
    private String startDateWorkFlow;
    private String endDateWorkFlow;
    private long serviceId;

}
