package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientWorkFlowDto {

    @Min(1)
    private long clientID;

    @Min(1)
    private long doctorID;

    @Future
    private LocalDateTime recipeDate;

    @Positive
    private long serviceID;
}
