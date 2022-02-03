package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "MEDICALCARD_BODY")
/*@AssociationOverrides(
        {@AssociationOverride(name = "primaryKey.doctor", joinColumns = @JoinColumn(name = "doctor_id")),
         @AssociationOverride(name = "primaryKey.client", joinColumns = @JoinColumn(name = "client_id"))}
)*/
public class MedicalCardBody implements Serializable {

    /*@EmbeddedId
    private MedicalCardBodyPK primaryKey = new MedicalCardBodyPK();*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    /*@Transient
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
    }*/

}
