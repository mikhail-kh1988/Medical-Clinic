package com.medclinic.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Data
@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "sum")
    private int sum;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "paid_date")
    private LocalDate paidDate;

}
