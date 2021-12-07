package com.medclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardBodyDto {

    private String comment;
    private long doctorID;
    private long clientID;
    private LocalDate createDate;
    private long diseaseID;
    private String complaint;
    private String therapy;
    private long departmentID;
    private long medicalCardID;

    @Future
    private String futureDateRecipient;
    private boolean therapyClosed;

}
