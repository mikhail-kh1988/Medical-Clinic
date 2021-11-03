package com.medclinic.dto;

public class DescribeUpdateAnalysisSvcResult {

    private String result;
    private String marks;
    private long whoCheckedID;

    public DescribeUpdateAnalysisSvcResult(String result, String marks, long whoCheckedID) {
        this.result = result;
        this.marks = marks;
        this.whoCheckedID = whoCheckedID;
    }

    public DescribeUpdateAnalysisSvcResult(){}

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public long getWhoCheckedID() {
        return whoCheckedID;
    }

    public void setWhoCheckedID(long whoCheckedID) {
        this.whoCheckedID = whoCheckedID;
    }
}
