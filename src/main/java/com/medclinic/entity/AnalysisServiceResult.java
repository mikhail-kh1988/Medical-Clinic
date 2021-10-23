package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.GregorianCalendar;

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
    private GregorianCalendar createDate;

    @Column(name = "submit_date")
    private GregorianCalendar submitDate;

    @OneToOne
    private Bill bill;

    public MedicalService getService() {
        return service;
    }

    public void setService(MedicalService service) {
        this.service = service;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Doctor getWhoSender() {
        return whoSender;
    }

    public void setWhoSender(Doctor whoSender) {
        this.whoSender = whoSender;
    }

    public Doctor getWhoMakeCheck() {
        return whoMakeCheck;
    }

    public void setWhoMakeCheck(Doctor whoMakeCheck) {
        this.whoMakeCheck = whoMakeCheck;
    }

    public GregorianCalendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(GregorianCalendar createDate) {
        this.createDate = createDate;
    }

    public GregorianCalendar getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(GregorianCalendar submitDate) {
        this.submitDate = submitDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
