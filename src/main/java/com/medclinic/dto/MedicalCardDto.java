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
public class MedicalCardDto {

    private long clientID;
    private GregorianCalendar createDate;
    private String describe;
    private String bloodGroup;
    private String chronicDisease;

}
