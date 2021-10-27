package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "medcard")
public class MedicalCardClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @Column(name = "create_date")
    private GregorianCalendar createDate;

    @Column(name = "describe")
    private String describe;

    @Column(name = "blood_group", length = 6)
    private String bloodGroup;

    @Column(name = "chronic_disease", length = 100)
    private String chronicDisease;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor therapyDoctor;

    @OneToMany(mappedBy = "primaryKey.doctor",
            cascade = CascadeType.ALL)
    private Set<MedicalCardBody> medicalCardBodies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public GregorianCalendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(GregorianCalendar createDate) {
        this.createDate = createDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public Doctor getTherapyDoctor() {
        return therapyDoctor;
    }

    public void setTherapyDoctor(Doctor therapyDoctor) {
        this.therapyDoctor = therapyDoctor;
    }

    public Set<MedicalCardBody> getMedicalCardBodies() {
        return medicalCardBodies;
    }

    public void setMedicalCardBodies(Set<MedicalCardBody> medicalCardBodies) {
        this.medicalCardBodies = medicalCardBodies;
    }
}
