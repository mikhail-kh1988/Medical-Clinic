package com.medclinic.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "bill")
public class Bill {

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
    private GregorianCalendar createDate;

    @Column(name = "paid_date")
    private GregorianCalendar paidDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public GregorianCalendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(GregorianCalendar createDate) {
        this.createDate = createDate;
    }

    public GregorianCalendar getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(GregorianCalendar paidDate) {
        this.paidDate = paidDate;
    }
}
