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
public class MedicalCardBodyDTO {

    private String comment;
    private long doctorID;
    private long clientID;
    private GregorianCalendar createDate;
    private long diseaseID;
    private String therapy;
    private long departmentID;
    private long medicalCardID;
    private GregorianCalendar futureDateRecipient;
    private boolean therapyClosed;

}
