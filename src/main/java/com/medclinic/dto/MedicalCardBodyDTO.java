package com.medclinic.dto;

import java.util.GregorianCalendar;

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

    public MedicalCardBodyDTO(String comment, long doctorID, long clientID, GregorianCalendar createDate,
                              long diseaseID, String therapy, long departmentID, long medicalCardID,
                              GregorianCalendar futureDateRecipient, boolean therapyClosed) {
        this.comment = comment;
        this.doctorID = doctorID;
        this.clientID = clientID;
        this.createDate = createDate;
        this.diseaseID = diseaseID;
        this.therapy = therapy;
        this.departmentID = departmentID;
        this.medicalCardID = medicalCardID;
        this.futureDateRecipient = futureDateRecipient;
        this.therapyClosed = therapyClosed;
    }

    public MedicalCardBodyDTO() {}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

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

    public long getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(long diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    public long getMedicalCardID() {
        return medicalCardID;
    }

    public void setMedicalCardID(long medicalCardID) {
        this.medicalCardID = medicalCardID;
    }

    public GregorianCalendar getFutureDateRecipient() {
        return futureDateRecipient;
    }

    public void setFutureDateRecipient(GregorianCalendar futureDateRecipient) {
        this.futureDateRecipient = futureDateRecipient;
    }

    public boolean isTherapyClosed() {
        return therapyClosed;
    }

    public void setTherapyClosed(boolean therapyClosed) {
        this.therapyClosed = therapyClosed;
    }
}
