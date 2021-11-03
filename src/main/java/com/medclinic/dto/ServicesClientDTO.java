package com.medclinic.dto;

public class ServicesClientDTO {
    private long clientID;
    private long analysisID;
    private long serviceID;
    private long doctorID;

    public ServicesClientDTO(long clientID, long analysisID, long serviceID, long doctorID) {
        this.clientID = clientID;
        this.analysisID = analysisID;
        this.serviceID = serviceID;
        this.doctorID = doctorID;
    }

    public ServicesClientDTO() {}

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getAnalysisID() {
        return analysisID;
    }

    public void setAnalysisID(long analysisID) {
        this.analysisID = analysisID;
    }

    public long getServiceID() {
        return serviceID;
    }

    public void setServiceID(long serviceID) {
        this.serviceID = serviceID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }
}
