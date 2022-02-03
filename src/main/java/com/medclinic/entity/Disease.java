package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "diseases")
public class Disease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_code")
    private String internalCode;

    @Column(name = "external_code")
    private String externalCode;

    @Column(name = "world_code")
    private String worldCode;

}
