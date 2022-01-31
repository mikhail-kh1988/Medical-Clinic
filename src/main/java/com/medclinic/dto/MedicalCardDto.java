package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.GregorianCalendar;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardDto {

    @Positive
    private long clientID;

    @NotBlank
    private String describe;

    @NotBlank
    private String bloodGroup;

    @NotBlank
    private String chronicDisease;

}
