package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Data
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    private User createUser;

}
