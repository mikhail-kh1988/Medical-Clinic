package com.medclinic.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "workflow")
public class WorkFlow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



}
