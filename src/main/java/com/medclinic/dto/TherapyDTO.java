package com.medclinic.dto;

public class TherapyDTO {

    private String Therapy;
    private String describeComplaint;
    private long diseaseID;


    public TherapyDTO(String therapy, String describeComplaint, long diseaseID) {
        Therapy = therapy;
        this.describeComplaint = describeComplaint;
        this.diseaseID = diseaseID;
    }

    public TherapyDTO() {
    }

    public String getTherapy() {
        return Therapy;
    }

    public void setTherapy(String therapy) {
        Therapy = therapy;
    }

    public String getDescribeComplaint() {
        return describeComplaint;
    }

    public void setDescribeComplaint(String describeComplaint) {
        this.describeComplaint = describeComplaint;
    }

    public long getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(long diseaseID) {
        this.diseaseID = diseaseID;
    }
}
