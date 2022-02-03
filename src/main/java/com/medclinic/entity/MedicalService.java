package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "services")
public class MedicalService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String describe;
    private int price;
    private boolean active;

    @Column(name = "external_code")
    private String externalCode;

}
