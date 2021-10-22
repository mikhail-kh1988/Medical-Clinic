package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "analysis_result")
public class AnalysisResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



}
