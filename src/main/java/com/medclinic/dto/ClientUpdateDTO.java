package com.medclinic.dto;

public class ClientUpdateDTO {

    private String phoneNumber;
    private String about;
    private String actualAddress;

    public ClientUpdateDTO(String phoneNumber, String about, String actualAddress) {
        this.phoneNumber = phoneNumber;
        this.about = about;
        this.actualAddress = actualAddress;
    }

    public ClientUpdateDTO() {}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }
}
