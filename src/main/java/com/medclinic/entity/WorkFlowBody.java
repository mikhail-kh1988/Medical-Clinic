package com.medclinic.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "WORKFLOW_BODY")
public class WorkFlowBody implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private WorkFlow workFlow;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "receipt_date")
    private LocalDateTime receiptOfDate;

    @Column(name = "describe_complaint")
    private String describeComplain;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalService service;

    @Column(name = "receipt")
    private boolean receipt;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
}
