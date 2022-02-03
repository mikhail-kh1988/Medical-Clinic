package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Data
@Entity
@Table(name = "analysis_service_result")
public class AnalysisServiceResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    private Analysis analysis;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalService service;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @Column(name = "marks")
    private String marks;

    @Column(name = "result")
    private String result;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor whoSender;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor whoMakeCheck;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "submit_date")
    private LocalDate submitDate;

    @OneToOne
    private Bill bill;

}
