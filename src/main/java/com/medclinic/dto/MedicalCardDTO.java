package com.medclinic.dto;

import com.medclinic.entity.Client;
import com.medclinic.entity.Doctor;

import javax.persistence.CascadeType;
import java.util.GregorianCalendar;

public class MedicalCardDTO {

    private long clientID;
    private GregorianCalendar createDate;
    private String describe;
    private String bloodGroup;
    private String chronicDisease;

    public MedicalCardDTO(long clientID, GregorianCalendar createDate, String describe, String bloodGroup, String chronicDisease) {
        this.clientID = clientID;
        this.createDate = createDate;
        this.describe = describe;
        this.bloodGroup = bloodGroup;
        this.chronicDisease = chronicDisease;
    }

    public MedicalCardDTO() {}

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public GregorianCalendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(GregorianCalendar createDate) {
        this.createDate = createDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }
}
