package com.medclinic.dto;

public class ResultByAnalysisDTO {

    private long clientID;
    private long doctorID;
    private long analysisID;

    public ResultByAnalysisDTO(long clientID, long doctorID, long analysisID) {
        this.clientID = clientID;
        this.doctorID = doctorID;
        this.analysisID = analysisID;
    }

    public ResultByAnalysisDTO() {
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

    public long getAnalysisID() {
        return analysisID;
    }

    public void setAnalysisID(long analysisID) {
        this.analysisID = analysisID;
    }
}
