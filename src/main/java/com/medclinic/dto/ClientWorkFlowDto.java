package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientWorkFlowDto {

    @Positive
    private long clientID;

    @Positive
    private long doctorID;

    @Future
    private LocalDateTime recipeDate;

    @Positive
    private long serviceID;
}
