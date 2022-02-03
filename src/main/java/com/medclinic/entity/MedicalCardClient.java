package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

@Data
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

}
