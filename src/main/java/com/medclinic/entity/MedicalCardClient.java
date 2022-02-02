package com.medclinic.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MEDCARD")
public class MedicalCardClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "describe")
    private String describe;

    @Column(name = "blood_group", length = 6)
    private String bloodGroup;

    @Column(name = "chronic_disease", length = 100)
    private String chronicDisease;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor therapyDoctor;

    /*@OneToMany(mappedBy = "primaryKey.client",
            cascade = CascadeType.ALL)*/
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
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
