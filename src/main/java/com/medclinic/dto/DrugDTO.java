package com.medclinic.dto;

import javax.persistence.Column;

public class DrugDTO {

    private String name;
    private String activeElement;
    private String composition;
    private String dosage;

    public DrugDTO(String name, String activeElement, String composition, String dosage) {
        this.name = name;
        this.activeElement = activeElement;
        this.composition = composition;
        this.dosage = dosage;
    }

    public DrugDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveElement() {
        return activeElement;
    }

    public void setActiveElement(String activeElement) {
        this.activeElement = activeElement;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
