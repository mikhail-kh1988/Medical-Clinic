package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Set;

@Data
@Entity
@Table(name = "workflow")
public class WorkFlow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @OneToMany(mappedBy = "primaryKey.doctor",
            cascade = CascadeType.ALL)
    private Set<WorkFlowBody> bodySet;

    private boolean worked;

    @Column(name = "size_client")
    private int sizeClient;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalService service;


}
