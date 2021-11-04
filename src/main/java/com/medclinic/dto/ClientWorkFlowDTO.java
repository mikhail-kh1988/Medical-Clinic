package com.medclinic.dto;

import java.util.GregorianCalendar;

public class ClientWorkFlowDTO {

    private long clientID;
    private long doctorID;
    private GregorianCalendar recipeDate;
    private long serviceID;

    public ClientWorkFlowDTO(long clientID, long doctorID, GregorianCalendar recipeDate, long serviceID) {
        this.clientID = clientID;
        this.doctorID = doctorID;
        this.recipeDate = recipeDate;
        this.serviceID = serviceID;
    }

    public ClientWorkFlowDTO() {
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public GregorianCalendar getRecipeDate() {
        return recipeDate;
    }

    public void setRecipeDate(GregorianCalendar recipeDate) {
        this.recipeDate = recipeDate;
    }

    public long getServiceID() {
        return serviceID;
    }

    public void setServiceID(long serviceID) {
        this.serviceID = serviceID;
    }
}
