package com.medclinic.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MEDICALCARD_BODY")
public class MedicalCardBody implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Comment comment;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Therapy therapy;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalCardClient medicalCard;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disease disease;

    @Column(name = "future_date_recipient")
    private LocalDateTime futureDateRecipient;

    @Column(name = "therapy_closed")
    private boolean therapyClosed;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    private List<Pills> pillsList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    private List<Analysis> analysisList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

}
