package com.medclinic.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Data
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends User{

    private String about;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "actual_address")
    private String actualAddress;

    @Column(name = "birth_day")
    private LocalDate birthDay;
}
