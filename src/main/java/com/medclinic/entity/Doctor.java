package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
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

}
