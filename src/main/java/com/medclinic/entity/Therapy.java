package com.medclinic.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "therapy")
public class Therapy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean typical;

    @Column(name = "describe_complaint")
    private String describeComplaint;

    @ManyToOne(cascade = CascadeType.ALL)
    private Disease disease;

    @ManyToOne(cascade = CascadeType.ALL)
    private List<Drugs> typicalDrugList;

    @ManyToOne(cascade = CascadeType.ALL)
    private List<Analysis> typicalAnalysisList;






}
