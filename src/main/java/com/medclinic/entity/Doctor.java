package com.medclinic.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{

    @Column(name = "where_study")
    private String whereStudy;

    @Column(name = "specialization_name")
    private String specializationName;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MedicalService> myServices;

    public String getWhereStudy() {
        return whereStudy;
    }

    public void setWhereStudy(String whereStudy) {
        this.whereStudy = whereStudy;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Set<MedicalService> getMyServices() {
        return myServices;
    }

    public void setMyServices(Set<MedicalService> myServices) {
        this.myServices = myServices;
    }
}
