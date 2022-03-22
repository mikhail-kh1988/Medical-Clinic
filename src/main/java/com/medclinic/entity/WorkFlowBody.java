package com.medclinic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "receipt_date")
    private LocalDateTime receiptOfDate;

    @Column(name = "describe_complaint")
    private String describeComplain;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalService service;

    @Column(name = "receipt")
    private boolean receipt;

    //Удалить
    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    //Удалить
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
}
