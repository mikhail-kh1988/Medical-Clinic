package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientWorkFlowDto {

    private long clientID;
    private long doctorID;
    private GregorianCalendar recipeDate;
    private long serviceID;
}
