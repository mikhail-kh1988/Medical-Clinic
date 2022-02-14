package com.medclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "workflow")
public class WorkFlow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", updatable = false)
    private Set<WorkFlowBody> bodySet;

    private boolean worked;

    @Column(name = "size_client")
    private int sizeClient;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalService service;


}
