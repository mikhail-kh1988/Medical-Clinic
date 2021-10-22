package com.medclinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.GregorianCalendar;

@Entity
public class Client extends User{

    private String about;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "actual_address")
    private String actualAddress;

    @Column(name = "birth_day")
    private GregorianCalendar birthDay;

    public GregorianCalendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(GregorianCalendar birthDay) {
        this.birthDay = birthDay;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }
}
