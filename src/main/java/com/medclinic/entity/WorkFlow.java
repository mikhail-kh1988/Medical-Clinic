package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Set;

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

    public int getSizeClient() {
        return sizeClient;
    }

    public void setSizeClient(int sizeClient) {
        this.sizeClient = sizeClient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Set<WorkFlowBody> getBodySet() {
        return bodySet;
    }

    public void setBodySet(Set<WorkFlowBody> bodySet) {
        this.bodySet = bodySet;
    }

    public boolean isWorked() {
        return worked;
    }

    public void setWorked(boolean worked) {
        this.worked = worked;
    }

    public MedicalService getService() {
        return service;
    }

    public void setService(MedicalService service) {
        this.service = service;
    }
}
