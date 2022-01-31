package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardBodyDto {

    @NotBlank
    private String comment;

    @Positive
    private long doctorID;

    @Positive
    private long clientID;

    @PastOrPresent
    private LocalDate createDate;

    @Positive
    private long diseaseID;

    @NotBlank
    private String complaint;

    @NotBlank
    private String therapy;

    @Positive
    private long departmentID;

    @Positive
    private long medicalCardID;

    @Future
    private String futureDateRecipient;
    private boolean therapyClosed;

}
