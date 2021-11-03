package com.medclinic.dto;

public class DescribeAnalysisDTO {

    private String name;
    private int price;
    private String describe;

    public DescribeAnalysisDTO(String name, int price, String describe) {
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public DescribeAnalysisDTO(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
