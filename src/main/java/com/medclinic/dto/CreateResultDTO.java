package com.medclinic.dto;

public class CreateResultDTO {

    public long analysisID;
    public long serviceID;
    public long doctorID;
    public long clientID;

    public CreateResultDTO(long analysisID, long doctorID, long clientID, long serviceID) {
        this.analysisID = analysisID;
        this.doctorID = doctorID;
        this.clientID = clientID;
        this.serviceID = serviceID;
    }

    public CreateResultDTO() {}

    public long getAnalysisID() {
        return analysisID;
    }

    public void setAnalysisID(long analysisID) {
        this.analysisID = analysisID;
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

    public long getServiceID() {
        return serviceID;
    }

    public void setServiceID(long serviceID) {
        this.serviceID = serviceID;
    }
}
