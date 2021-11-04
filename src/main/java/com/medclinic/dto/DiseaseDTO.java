package com.medclinic.dto;

import javax.persistence.Column;

public class DiseaseDTO {
    private String name;
    private String internalCode;
    private String externalCode;
    private String worldCode;

    public DiseaseDTO(String name, String internalCode, String externalCode, String worldCode) {
        this.name = name;
        this.internalCode = internalCode;
        this.externalCode = externalCode;
        this.worldCode = worldCode;
    }

    public DiseaseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getWorldCode() {
        return worldCode;
    }

    public void setWorldCode(String worldCode) {
        this.worldCode = worldCode;
    }
}
