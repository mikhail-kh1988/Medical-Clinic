package com.medclinic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MEDCARD")
public class MedicalCardClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Client client;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "describe")
    private String describe;

    @Column(name = "blood_group", length = 6)
    private String bloodGroup;

    @Column(name = "chronic_disease", length = 100)
    private String chronicDisease;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Doctor therapyDoctor;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", updatable = false)
    private Set<MedicalCardBody> medicalCardBodies;

}
