package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientWorkFlowDto {

    private long clientID;
    private long doctorID;

    @Future
    private LocalDateTime recipeDate;
    private long serviceID;
}
