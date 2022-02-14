package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
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
    private String recipeDate;

    @Positive
    private long serviceID;

    @NotBlank
    private String complaint;
}
