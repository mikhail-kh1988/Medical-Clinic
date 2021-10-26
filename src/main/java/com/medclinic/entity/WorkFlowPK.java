package com.medclinic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class WorkFlowPK implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
