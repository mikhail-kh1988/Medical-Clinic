package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardBodyDto {

    @NotBlank
    private String comment;

    @Min(1)
    private long doctorID;

    @Min(1)
    private long clientID;

    @PastOrPresent
    private LocalDate createDate;

    @Min(1)
    private long diseaseID;

    @NotBlank
    private String complaint;

    @NotBlank
    private String therapy;

    @Min(1)
    private long departmentID;

    @Min(1)
    private long medicalCardID;

    @Future
    private String futureDateRecipient;
    private boolean therapyClosed;

}
