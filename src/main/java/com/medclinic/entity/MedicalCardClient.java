package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medcard")
public class MedicalCardClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
