package com.medclinic.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MEDICALCARD_BODY")
@AssociationOverrides(
        {@AssociationOverride(name = "primaryKey.doctor", joinColumns = @JoinColumn(name = "doctor_id")),
         @AssociationOverride(name = "primaryKey.client", joinColumns = @JoinColumn(name = "client_id"))}
)
public class MedicalCardBody {

    @EmbeddedId
    private MedicalCardBodyPK primaryKey = new MedicalCardBodyPK();

    @ManyToOne(cascade = CascadeType.ALL)
    private Comment comment;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Therapy therapy;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    private MedicalCardClient medicalCard;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disease disease;

    @Column(name = "future_date_recipient")
    private LocalDateTime futureDateRecipient;

    @Column(name = "therapy_closed")
    private boolean therapyClosed;

    @OneToMany
    private List<Pills> pillsList;

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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
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

    public List<Pills> getDrugsList() {
        return pillsList;
    }

    public void setDrugsList(List<Pills> pillsList) {
        this.pillsList = pillsList;
    }

    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    public LocalDateTime getFutureDateRecipient() {
        return futureDateRecipient;
    }

    public void setFutureDateRecipient(LocalDateTime futureDateRecipient) {
        this.futureDateRecipient = futureDateRecipient;
    }

    public boolean isTherapyClosed() {
        return therapyClosed;
    }

    public void setTherapyClosed(boolean therapyClosed) {
        this.therapyClosed = therapyClosed;
    }
}
