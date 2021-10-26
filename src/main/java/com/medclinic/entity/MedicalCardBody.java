package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "MEDICALCARD_BODY")
public class MedicalCardBody implements Serializable {

    @EmbeddedId
    private MedicalCardBodyPK primaryKey;

    @ManyToOne(cascade = CascadeType.ALL)
    private Comment comment;

    @Column(name = "create_date")
    private GregorianCalendar createDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Therapy therapy;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalCardClient medicalCard;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disease disease;

    @Column(name = "future_date_recipient")
    private GregorianCalendar futureDateRecipient;

    @Column(name = "therapy_closed")
    private boolean therapyClosed;

    @OneToMany
    private List<Drugs> drugsList;

    @OneToMany
    private List<Analysis> analysisList;

    @Transient
    public Doctor getDoctor(){
        return primaryKey.getDoctor();
    }

    @Transient
    public Client getClient(){
        return primaryKey.getClient();
    }

    public void setDoctor(Doctor doctor){
        primaryKey.setDoctor(doctor);
    }

    public void setClient(Client client){
        primaryKey.setClient(client);
    }

    public MedicalCardBodyPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(MedicalCardBodyPK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public GregorianCalendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(GregorianCalendar createDate) {
        this.createDate = createDate;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public MedicalCardClient getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCardClient medicalCard) {
        this.medicalCard = medicalCard;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Drugs> getDrugsList() {
        return drugsList;
    }

    public void setDrugsList(List<Drugs> drugsList) {
        this.drugsList = drugsList;
    }

    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    public GregorianCalendar getFutureDateRecipient() {
        return futureDateRecipient;
    }

    public void setFutureDateRecipient(GregorianCalendar futureDateRecipient) {
        this.futureDateRecipient = futureDateRecipient;
    }

    public boolean isTherapyClosed() {
        return therapyClosed;
    }

    public void setTherapyClosed(boolean therapyClosed) {
        this.therapyClosed = therapyClosed;
    }
}
